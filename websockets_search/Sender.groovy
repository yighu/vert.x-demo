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

import groovy.json.JsonSlurper 
import java.util.Random  
def somenews(){
def terms=["iphone","android","columbus","apple","google","twitter"]
	Random rand = new Random()  

    def queryterm = terms.getAt(rand.nextInt(terms.size()))
//println "Searching news on:"+queryterm
    def q = "http://api.duckduckgo.com/?q=${queryterm}&format=json"
    def feed = new JsonSlurper().parseText(new URL( q ).text)
def result=[]
result<<feed.Heading+"<br>"
feed.RelatedTopics.each{it->
	if (it.Result) result<<it.Result<<"<br/>"
}
result
}

def eb = vertx.eventBus

vertx.setPeriodic(1000) {
	def news=somenews()
  eb.publish("news-feed", news.toString())
//println "sending news"
}
