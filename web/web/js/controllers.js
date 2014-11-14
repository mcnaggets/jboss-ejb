var userControllers = angular.module('userControllers', []);

userControllers.controller('UserListController', ['$scope', 'User',
    function ($scope, User) {
        $scope.users = User.query();
        $scope.orderProp = 'name';
        $scope.generateUser = function() {
            var user = new User({login: 'test', name: 'Test'});
            user.$save();
            $scope.users.push(user);
        };
    }
]);

userControllers.controller('UserDetailController', ['$scope', '$routeParams', 'User',
    function ($scope, $routeParams, User) {
        $scope.user = User.get({userId: $routeParams.userId});
    }
]);
