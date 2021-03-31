//SHOW company
var app = angular.module("myApp", []);
app.controller("proCtrl", function ($scope, $http) {
  //show company
  $http.get("http://localhost:9096/companies").then(function (reponse) {
    $scope.list_company = reponse.data;
  });

  //Buttons Settings
  $scope.submit = true;
  $scope.update = false;
  $scope.cancel = false;
  $scope.companyid = false;
  $scope.updateForm = false;
  //Create New company
  $scope.createCompany = function () {
    //$http POST function
    $http({
      method: "POST",
      url: "http://localhost:9096/companies",
      data: $scope.company,
    }).then(
      function successCallback(response) {
        $scope.list_company.push(response.data);
        alert("Company has created Successfully");
      },
      function errorCallback(response) {
        alert("Error. While created company. Try Again!");
      }
    );
  };

   //Update company
   $scope.updateCompany = function() {

    //$http PUT function
    $http({

      method: 'PUT',
      url: 'http://localhost:9096/companies/' + $scope.company.id,
      data: $scope.company

    }).then(function successCallback(response) {

      alert("Company has updated Successfully")

    }, function errorCallback(response) {

      alert("Error. while updating Company Try Again!");

    });

  };

  //Delete company
  $scope.deleteCompany = function(company) {

    //$http DELETE function
    $http({

      method: 'DELETE',
      url: 'http://localhost:9096/companies/' + company.id

    }).then(function successCallback(response) {

      alert("Company has deleted Successfully");
      var index = $scope.list_company.indexOf(company);
      $scope.list_company.splice(index, 1);

    }, function errorCallback(response) {

      alert("Error. while deleting company Try Again!");

    });

  };

  //Set $scope on Edit button click
  $scope.editCompany = function(company) {

    $scope.company = company;
    $scope.submit = false;
    $scope.update = true;
    $scope.cancel = true;
    $scope.companyid = false;
    $scope.updateForm = true;
  };


  //cancel Uodate
  $scope.cancelUpdate = function() {
    $scope.company = null;
    $scope.submit = true;
    $scope.update = false;
    $scope.cancel = false;
    $scope.companyid = true;
  };
});
