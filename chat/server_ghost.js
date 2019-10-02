var Router = require("vertx-web-js/router");
var SockJSHandler = require("vertx-web-js/sock_js_handler");
var StaticHandler = require("vertx-web-js/static_handler");

var eb = vertx.eventBus();

eb.consumer("chat.to.server").handler(function (message) {
  var timestamp = Java.type("java.text.DateFormat").getDateTimeInstance(Java.type("java.text.DateFormat").SHORT, Java.type("java.text.DateFormat").MEDIUM).format(Java.type("java.util.Date").from(Java.type("java.time.Instant").now()));
  eb.publish("chat.to.client", timestamp + ": javascript say " + message.body());
});

