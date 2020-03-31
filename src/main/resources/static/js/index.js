var stompClient = null;

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/sock/subscribe', function (washers) {
            var washersBody = washers.body;
            console.log(JSON.parse(washersBody));

            var washers = JSON.parse(washersBody);
            drawFunction(washers);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function refresh() {
//    stompClient.send("/app/refresh", {}, JSON.stringify({'name': $("#name").val()}));
    stompClient.send("/app/refresh", {}, null);
}

$(function () {
    connect();
//    $( "#connect" ).click(function() { connect(); });
//    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#refresh" ).click(function() { refresh(); });
});