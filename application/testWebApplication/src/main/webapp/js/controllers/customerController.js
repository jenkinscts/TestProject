O2App.controller('AllCustomerDetailsController',
function ($scope, $http) {
  console.log('Called the AllCustomerDetailsController');
  $http.get('http://localhost:8080/testWebApplication/rest/getCustomerDetails').success(function(data, status, headers, config) {
    $scope.customers = data;
  });
  }
);
