var app = angular.module('myApp', []);

/*
app.controller('columnWriteCtrl', function($scope, $http) {
	console.log("column 1");
	var getColumn = function() {
		console.log("Test");
		$http.get('http://localhost:8080/getColService/rest/column/get')
				.success(function(data) {
					$scope.columns = data;
				});
	};
	getColumn();
}); */




app.controller('scenarioCtrl', function($scope, $http) {
	console.log("scenario 1");
	var getScenario = function() {
		console.log("Test");
		$http.get('http://localhost:8080/getColService/rest/service/getScenario')
				.success(function(data) {
					$scope.scenarios = data;
				});
            $scope.searchFilter = function (data) {
		    var keyword = new RegExp($scope.nameFilter, 'i');
		    return !$scope.nameFilter || keyword.test(data.scenario.scenarioName) || keyword.test(data.scenario.queryId);
		};
	};
	getScenario();
});

app.controller('queryCtrl', function($scope, $http) {
	console.log("query 1");
	var getQuery = function() {
		console.log("Test");
		$http.get('http://localhost:8080/getColService/rest/service/getQuery')
				.success(function(data) {
					$scope.queries = data;
				});
	};
	getQuery();
});
