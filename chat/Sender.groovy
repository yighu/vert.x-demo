
def eb = vertx.eventBus()
def i=0
vertx.setPeriodic(1000) {
  eb.send("news-feed", "Some news! "+ i++)
}
