//SHOW USER
var app = angular.module("myApp", []);
app.controller("proCtrl", function ($scope, $http) {
  //show user
  $http.get("http://localhost:9095/users").then(function (reponse) {
    $scope.list_users = reponse.data;
  });

  //Buttons Settings
  $scope.submit = true;
  $scope.update = false;
  $scope.cancel = false;
  $scope.userid = false;
  $scope.updateForm = false;
  //Create New User
  $scope.createUser = function () {
    //$http POST function
    $http({
      method: "POST",
      url: "http://localhost:9095/users",
      data: $scope.user,
    }).then(
      function successCallback(response) {
        $scope.list_users.push(response.data);
        alert("User has created Successfully");
      },
      function errorCallback(response) {
        alert("Error. while created user Try Again!");
      }
    );
  };

   //Update User
   $scope.updateUser = function() {

    //$http PUT function
    $http({

      method: 'PUT',
      url: 'http://localhost:9095/users/' + $scope.user.id,
      data: $scope.user

    }).then(function successCallback(response) {

      alert("User has updated Successfully")

    }, function errorCallback(response) {

      alert("Error. while updating user Try Again!");

    });

  };

  //Delete User
  $scope.deleteUser = function(user) {

    //$http DELETE function
    $http({

      method: 'DELETE',
      url: 'http://localhost:9095/users/' + user.id

    }).then(function successCallback(response) {

      alert("User has deleted Successfully");
      var index = $scope.list_users.indexOf(user);
      $scope.list_users.splice(index, 1);

    }, function errorCallback(response) {

      alert("Error. while deleting user Try Again!");

    });

  };

  //Set $scope on Edit button click
  $scope.editUser = function(user) {

    $scope.user = user;
    $scope.submit = false;
    $scope.update = true;
    $scope.cancel = true;
    $scope.userid = false;
    $scope.updateForm = true;
  };


  //cancel Uodate
  $scope.cancelUpdate = function() {
    $scope.user = null;
    $scope.submit = true;
    $scope.update = false;
    $scope.cancel = false;
    $scope.userid = true;
  };
});
