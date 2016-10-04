//contains The logic of our Client app
var stompClient = null;

function setConnected(connected) 
{
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	
	if(connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	
	$("#greetings").html("");
}

//Uses SockJS and stomp.js to open a connection to "gs-guide-websocket"
//which is where out SockJS server is waiting for connections.
function connect() {
	var socket = new SockJS('gs-guide-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, 
	function(frame)
	{
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/greetings', 
				function(greeting)
				{
					showGreeting(JSON.parse(greeting.body).content);
				});
	});
}

function disconnect()
{
	if(stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

//Retreives the name entered by the user and uses the
//STOMP client to send it to the "/app/hello" destination
//(where GreetingController.greeting() will receive it)
function sendName()
{
	stompClient.send("/app/hello", {}, 
			JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message)
{
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function(){
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {connect(); });
	$("#disconnect").click(function() {disconnect(); });
	$("#send").click(function() {sendName(); });
});