var usersApp = angular.module('usersApp', ['ngRoute', 'userControllers', 'userServices']);

usersApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/users', {
                templateUrl: 'partials/user-list.html',
                controller: 'UserListController'
            }).
            when('/users/:userId', {
                templateUrl: 'partials/user-detail.html',
                controller: 'UserDetailController'
            }).
            otherwise({
                redirectTo: '/users'
            });
    }]);