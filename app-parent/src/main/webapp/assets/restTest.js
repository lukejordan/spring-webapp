var app = angular.module("MyApp", []);

app.controller("PostsCtrl", function($scope, $http) {
  $http.get('service/test').
    success(function(data, status, headers, config) {
      $scope.posts = data;
    }).
    error(function(data, status, headers, config) {
      // log error
    });
});

app.controller("PostsMultiple", function($scope, $http) {
	  $http.get('service/testMultiple').
	    success(function(data, status, headers, config) {
	      $scope.posts = data;
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	});


