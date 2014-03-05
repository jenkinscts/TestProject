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
    .when('/updateCustomer/:customer',{
      controller: 'UpdateCustomerController',
      templateUrl: 'views/updateCustomer.html'
    })
   .when('/deleteCustomer/:customerId',{
        controller: 'DeleteCustomerController',
         templateUrl: 'views/customerDetails.html'
      })
   .when('/updateBilling/:bill',{
        controller: 'UpdateBillController',
        templateUrl: 'views/updateBill.html'
      })
   .when('/deleteBilling/:customerId',{
        controller: 'DeleteBillController',
        templateUrl: 'views/billingDetails.html'
      })
  ;
};

var O2App = angular.module('O2App', []).config(o2AppConfig);