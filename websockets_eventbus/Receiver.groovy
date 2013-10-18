def eb = vertx.eventBus

eb.registerHandler("news-feed", { message ->
  println "Received news: ${message.body()}"
})
