var o2AppConfig = function($routeProvider) {
  console.log('o2 App has been loaded');
  $routeProvider
    .when('/addCustomer', {
      controller: 'AddCustomerController',
      templateUrl: 'views/addCustomer.html'
    })
    .when('/customerDetails', {
            controller: 'AllCustomerDetailsController',
            templateUrl: 'views/customerDetails.html'
    })
    .when('/billingDetails', {
      controller: 'AllBillingDetailsController',
      templateUrl: 'views/billingDetails.html'
    })
  ;
};

var O2App = angular.module('O2App', []).config(o2AppConfig);