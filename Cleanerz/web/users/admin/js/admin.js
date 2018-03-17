/// <reference path="angular.min.js" />

var myApp = angular
    .module("myModule", [])
    .controller("myController", function($scope, $http) {
        
        $http({
            method: "POST",
            url: "http://localhost:8080/Cleanerz/loadInfoServlet"
        }).then(function mySuccess(response) {
            $scope.user = response.data;
        });

        $http({
            method: "GET",
            url: "http://localhost:8080/Cleanerz/appServlet"
        }).then(function mySuccess(response) {
            data = response.data;
            console.log(data);
            $scope.appointment = response.data;
        });

    });
