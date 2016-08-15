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


app.controller('PostData2', ['$scope', '$http', '$log', function($scope, $http, $log) {
	  $scope.submitted = false;
	  
	  $scope.submit = function() {
		console.log('This is some output')
	    //$scope.submitted = true;
		
		var data = '{"key": "value"}';
		
        $http.post('service/testPost', data, config)
        .success(function (data, status, headers, config) {
            $scope.PostDataResponse = data;
        })
        .error(function (data, status, header, config) {
//            $scope.ResponseDetails = "Data: " + data +
//                "<hr />status: " + status +
//                "<hr />headers: " + header +
//                "<hr />config: " + config;
		})
		
	  };
	  

		
	}
]);


app.controller('PostData', ['$scope', '$http', '$log', function($scope, $http, $log) {
	  $scope.submitted = false;
	  
	  $scope.submit = function(formData) {
		console.log('This is some output')
	    //$scope.submitted = true;
		
		var data = '{"key": "value"}'
		data = formData
		
		$http.post('service/testPost2', data).then(function successCallback(response) {
			// this callback will be called asynchronously
			// when the response is available
			console.log('1.a')
			$log.debug('This is a success')
			$log.debug('This is a success' + response.data.firstName)
		}, function errorCallback(response) {
		    // called asynchronously if an error occurs
			// or server returns response with an error status.
			console.log('1.b')
			$log.debug('This is a failure')
		})
		
	  };
	  

		
	}
]);