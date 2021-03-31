//SHOW company
var app = angular.module("myApp", []);
app.controller("proCtrl", function ($scope, $http) {
  //show company
  $http.get("http://localhost:9096/companies").then(function (reponse) {
    $scope.list_company = reponse.data;
  });
});
