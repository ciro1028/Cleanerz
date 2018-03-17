var appAdmin = angular
                .module("adminPages", ["ngRoute"])
                .config(function ($routeProvider, $locationProvider){
                    $locationProvider.hashPrefix('');
                    $routeProvider
                    .when('/adminHomeTemplate', {
                        templateUrl: "Templates/adminHomeTemplate.html",
                        controller: "adminHomeController"
                    })
                    .when("/adminAppointments", {
                        templateUrl: "Templates/adminAppointments.html"
                    })
                    .when("/adminUsers", {
                        templateUrl: "Templates/adminUsers.html"
                    })
                })
                .controller("adminHomeController", function($scope, $http) {
                    $http({
                        method: "POST",
                        url: "http://localhost:8080/Cleanerz/loadInfoServlet"
                    }).then(function mySuccess(response) {
                        $scope.user = response.data;
                    });
                })
              
                        


