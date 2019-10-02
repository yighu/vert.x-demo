
 vertx.eventBus().consumer("news-feed").handler({message -> 
            System.out.println("1 received message.body() = " + message.body());
        });
