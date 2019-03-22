package com.knowledgespike.proksy.core

data class Flags(val flag: String,
                 val longFlag: String,
                 val description: String )

class CommandLineArgs {

    data class StringResult(val stringValue: String, val reminder: List<String>)
    data class CollectionResult(val items: List<String>, val reminder: List<String>)

    var verb: String
    var url: String
    var flags: List<String>

    var items: List<String>

    constructor(args: Array<String>) {

        val cresult = getFlags(args.toList())
        flags = cresult.items
        var reminder = cresult.reminder

        var sresult = getVerb(reminder)
        verb = sresult.stringValue
        reminder = sresult.reminder

        sresult = getUrl(reminder)
        url = sresult.stringValue
        items = sresult.reminder
    }

    private fun getUrl(args: List<String>): StringResult {
        return StringResult("", args)
    }

    private fun getFlags(args: List<String>): CollectionResult {
        var lastIndex = 0
        // need all the flags herenbrhu
        /** shortflag, longflag, associatedfieldcount, descriptiion
         *
         * See http://commons.apache.org/proper/commons-cli/properties.html
         * */
        return CollectionResult(args.slice(0..lastIndex), args.drop(lastIndex + 1))
    }

    private fun getVerb(args: List<String>): StringResult {
        var verb = "GET"
        var drop = 0

        if (!isUrl(args[0])) {
            drop = 1
            verb = args[0]
        }

        return StringResult(verb, args.drop(drop))
    }

    private fun isUrl(possibleUrl: String): Boolean {
        return possibleUrl.contains('.')
    }

}