function AllBillingDetailsController($scope, $http) {
  console.log('Called the AllBillingDetailsController')
  $http.get('http://localhost:8080/testWebApplication/rest/getBillingDetails').success(function(data, status, headers, config) {
    $scope.bills = data;
  });
}


function BillingDetailsController($scope, $http) {
  console.log('Called the controller')
  $http.get('http://localhost:8080/testWebApplication/rest/getBillingDetails/id/1').success(function(data, status, headers, config) {
    $scope.bill = data;
  });
}