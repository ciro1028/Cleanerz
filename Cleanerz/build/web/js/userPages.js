var app = angular
                .module("clientPages", ["ngRoute"])
                .config(function ($routeProvider, $locationProvider){
                    $locationProvider.hashPrefix('');
                    $routeProvider
                    .when('/clientHome', {
                        templateUrl: "Templates/clientHome.html",
                    })
                    .when("/profile", {
                        templateUrl: "Templates/profile.html",
                    })
                    .when("/Schedules", {
                        templateUrl: "Schedules.html",
                    })
                })
              
                        


