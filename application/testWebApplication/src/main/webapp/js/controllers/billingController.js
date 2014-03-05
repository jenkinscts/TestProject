O2App.controller('AllBillingDetailsController',
function($scope, $http) {
  console.log('Called the AllBillingDetailsController')
  $http.get('http://localhost:8080/testWebApplication/rest/getBillingDetails').success(function(data, status, headers, config) {
    $scope.bills = data;
  });
 }
);



O2App.controller('UpdateBillController',
    function ($scope, $location, $routeParams,$http){
     console.log('Called the UpdateBillController');

     $scope.selectedBill = JSON.parse($routeParams.bill);

     $scope.submitUpdateForm = function(){
         if ($scope.billUpdateForm.$valid) {
                   	    console.log('Called the UpdateBillController for updating data');
                          $http({
                                  method  : 'PUT',
                                  url     : 'http://localhost:8080/testWebApplication/rest/updateBillingDetails',
                                  data    : JSON.stringify({customerId : $scope.selectedBill.customerId, sms : $scope.selectedBill.sms,
                                             balance : $scope.selectedBill.balance, calls : $scope.selectedBill.calls}),  // pass in data as strings
                                  headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
                              })
                                  .success(function(data) {
                                      console.log(data);
                                      $scope.message = "Success";
                                      if (!data.success) {
                                      	// if not successful, bind errors to error variables
                                          console.log('Error while calling');
                                      } else {
                                      	// if successful, bind success message to message
                                          $scope.message = "Some error while adding the billing";
                                      }
                                  });
                   alert($scope.message);
                   $location.path('/billingDetails');

                 }
     }


     $scope.cancelUpdateForm = function(){
         $location.path('/billingDetails');
     }
     }
);

O2App.controller('DeleteBillController',
function ($scope, $location, $routeParams,$http){
   $scope.customerId = $routeParams.customerId;

   console.log('Called the DeleteBillController'+ $scope.customerId);
    $http({
             method  : 'PUT',
             url     : 'http://localhost:8080/testWebApplication/rest/updateBillingDetails',
             data    : JSON.stringify({customerId : $scope.customerId, sms : 0,
                            balance : 0, calls : 0}),  // pass in data as strings
             headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
          })
          .success(function(data) {
              console.log(data);
              $scope.message = "Success";
              if (!data.success) {
           // if not successful, bind errors to error variables
           console.log('Error while calling');
           } else {
           // if successful, bind success message to message
           $scope.message = "Some error while adding the billing";
           }
        });
     alert("Deleted billing successfully");
     $location.path('/billingDetails');
}
);

