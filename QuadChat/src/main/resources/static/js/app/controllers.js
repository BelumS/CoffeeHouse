//The AngularJS Controller
//Forwards everything to a separate service
(function(angular) {
	angular.module("chatApp.controllers").controller("ChatCtrl", function($scope, ChatService) {
		$scope.messages = [];
		$scope.message = "";
		$scope.max = 140;

		//Receives the form submission, and forwards the msg to a service
		$scope.addMessage = function() {
			ChatService.send($scope.message);
			//Empty the field by resetting the message model to an empty string
			$scope.message = "";
		};

		//Invoke the service for receiving messages, returns a deferred, so that
		//each time a message is received, it updates the progress part of the directive
		//The controller will add the message to the messages array
		ChatService.receive().then(null, null, function(message) {
			$scope.messages.push(message);
		});
	});
})(angular);



