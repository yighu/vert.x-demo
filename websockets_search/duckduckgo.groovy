#!/usr/bin/env groovy
/*
  From http://www.ibm.com/developerworks/java/library/j-groovy09299/
 */
import groovy.json.JsonSlurper 
if (args) {
    def queryterm = args[0]
    def q = "http://api.duckduckgo.com/?q=${queryterm}&format=json"
    def feed = new JsonSlurper().parseText(new URL( q ).text)
println feed.Heading
feed.RelatedTopics.each{it->
println it.Result

}
}
else {
    println  "USAGE: twitsearch.groovy "
}
