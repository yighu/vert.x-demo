#!/usr/bin/env groovy
/*
  From http://www.ibm.com/developerworks/java/library/j-groovy09299/
 */
 
if (args) {
    def queryterm = args[0]
    def q = "http://search.twitter.com/search.atom?q=${queryterm}"
    def feed = new XmlSlurper().parse(q)
    feed.entry.each { entry ->
        println  """\
${entry.author.name} - ${entry.published}
\"${entry.title}\"
${'-' * 72}"""
    }
}
else {
    println  "USAGE: twitsearch.groovy "
}
