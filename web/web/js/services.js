var userServices = angular.module('userServices', ['ngResource']);

userServices.factory('User', ['$resource',
    function ($resource) {
        return $resource('users/', {}, {
            query: {method: 'GET', params: {userId: 'users'}, isArray: true}
        });
    }]);