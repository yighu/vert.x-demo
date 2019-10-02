import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.sockjs.SockJSHandler
import io.vertx.ext.web.handler.StaticHandler

def eb = vertx.eventBus()

eb.consumer("chat.to.server").handler({ message ->
  def timestamp = java.text.DateFormat.getDateTimeInstance(java.text.DateFormat.SHORT, java.text.DateFormat.MEDIUM).format(java.util.Date.from(java.time.Instant.now()))
  eb.send("chat.to.single", "${timestamp}: dup ${message.body()}")
})

