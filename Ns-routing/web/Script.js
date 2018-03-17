var app = angular.module("Demo", ["ngRoute"])
				.config(function($routeProvider, $locationProvider) {
                                        $locationProvider.hashPrefix('');
					$routeProvider
						.when("/homefds", {
							templateUrl: "Templates/home.html",
							controller: "homeController"
						})
						.when("/courses", {
							templateUrl: "Templates/courses.html",
							controller: "coursesController"
						})
						.when("/students", {
							templateUrl: "Templates/students.html",
							controller: "studentsController"
						})
						
				})
				.controller("homeController", function($scope) {
					$scope.message = "Home Page";
				})
				.controller("coursesController", function($scope) {
					$scope.courses = ["C#", "VB.NET", "SQL Server", "ASP.NET"];
				})
				.controller("studentsController", function($scope, $http) {

					 
				})