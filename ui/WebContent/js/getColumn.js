angular.module('ui.bootstrap.demo', [ 'ui.bootstrap' ]);
angular
		.module('ui.bootstrap.demo')
		.controller(
				'TypeaheadCtrl',
				function($scope, $http) {

					$scope.selected = undefined;
					// Any function returning a promise object can be used to
					// load values asynchronously
					$http.get(
							'http://localhost:8080/getColService/rest/service/getScenario')
					.then(function(response) {
						$scope.data = response.data;
						console.log($scope.data);
					});
//					
//					$scope.filterbyscenaioname = function() {
//						return $scope.data.map(function(item){
//					        return item.scenarioName;
//					      });
//					};
				});