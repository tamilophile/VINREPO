var app = angular.module('myApp', []);
app.controller('columnWriteCtrl', function($scope, $http) {
	console.log("Test 1");
	var getColumn = function() {
		console.log("Test");
		$http.get('http://localhost:8080/getColService/rest/column/get')
				.success(function(data) {
					$scope.columns = data;
				});
	};
	getColumn();
});
