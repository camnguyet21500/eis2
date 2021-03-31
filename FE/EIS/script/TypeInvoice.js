//SHOW invoice
var app = angular.module("myApp", []);
app.controller("proCtrl", function ($scope, $http) {
  //show invoice
  $http.get("http://localhost:9096/typeInvoices").then(function (reponse) {
    $scope.list_typeInvoices = reponse.data;
  });

});
