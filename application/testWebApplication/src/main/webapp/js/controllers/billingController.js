O2App.controller('AllBillingDetailsController',
function($scope, $http) {
  console.log('Called the AllBillingDetailsController')
  $http.get('http://localhost:8080/testWebApplication/rest/getBillingDetails').success(function(data, status, headers, config) {
    $scope.bills = data;
  });
 }
);
