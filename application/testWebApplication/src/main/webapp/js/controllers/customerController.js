function AllCustomerDetailsController($scope, $http) {
  console.log('Called the AllCustomerDetailsController');
  $http.get('http://localhost:8080/testWebApplication/rest/getCustomerDetails').success(function(data, status, headers, config) {
    $scope.customers = data;
  });
}

function CustomerDetailsController($scope, $http) {
  console.log('Called the CustomerDetailsController');
  $http.get('http://localhost:8080/testWebApplication/rest/getCustomerDetails/id/1').success(function(data, status, headers, config) {
    $scope.customer = data;
  });
}