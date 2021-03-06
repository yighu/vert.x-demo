/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package websockets_search

def eb = vertx.eventBus
vertx.createHttpServer().websocketHandler { ws ->
  ws.dataHandler { data -> ws.writeTextFrame(data.toString()) }
  eb.registerHandler("news-feed", { message ->
  println "Received news: ${message.body()}"
  ws.writeTextFrame(message.body()) }
  )
	
}.requestHandler { req ->
  if (req.uri == "/") req.response.sendFile "websockets/ws.html"
}.listen(8080)



