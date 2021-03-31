// document.addEventListener('login', function(){
//     p = document.querySelector('p');
//     p.addEventListener('click', doFetch);
// }
// );

// async function doFetch(){
//     window.location.href = 'http://127.0.0.1:5500/login.html'
// }

// document.addEventListener('login', function(){
//     login = document.getElementById('submit');
//     login.addEventListener('click', doFetch2)
// })

// async function doFetch2(event){
//     event.preventDefault();
//     let valueUsername = document.getElementById('username').value;
//     let valuePassword = document.getElementById('password').value;

//     let data = {
//         username: valueUsername,
//         password: valuePassword,
//     };

//     localStorage.removeItem('Token');
//     async function postData(url = '', data = {}){
//         const response = await fetch(url, {
//             method: 'POST',
//             mode: 'cors',
//             cache: 'no-cache',
//             credentials: 'same-origin',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(data)
//         });
//         return response.json;
//     }

//     postData('http://localhost:9095/users', data)
//     .then(response => {
//         let token1 = 'Bearer' + " " + response.token;
//         localStorage.setItem('Token', token1);
//         doFetch()
//     })
// }

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
      data: $scope.p,
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
      url: 'http://localhost:9095/users/' + $scope.p.id,
      data: $scope.p

    }).then(function successCallback(response) {

      alert("User has updated Successfully")

    }, function errorCallback(response) {

      alert("Error. while updating user Try Again!");

    });

  };

  //Delete User
  $scope.deleteUser = function(p) {

    //$http DELETE function
    $http({

      method: 'DELETE',
      url: 'http://localhost:9095/users/' + p.id

    }).then(function successCallback(response) {

      alert("User has deleted Successfully");
      var index = $scope.list_users.indexOf(p);
      $scope.list_users.splice(index, 1);

    }, function errorCallback(response) {

      alert("Error. while deleting user Try Again!");

    });

  };

  //Set $scope on Edit button click
  $scope.editUser = function(p) {

    $scope.p = p;
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
