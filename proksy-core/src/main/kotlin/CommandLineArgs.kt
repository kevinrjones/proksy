package com.knowledgespike.proksy.core

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import org.apache.commons.cli.*
import org.apache.commons.cli.Option.*

class CommandLineArgs(args: Array<String>) {

    private val options: Options
    private val commandLine: CommandLine

    var verb: String = "GET"
        private set

    // Option - Arrow
    var url: Option<String> = None
        private set


    init {
        options = buildOptions()
        val parser = DefaultParser()
        commandLine = parser.parse(options, args)

        if(commandLine.argList != null) {
            if (isUrl(commandLine.argList[0])) {
                url = Some(commandLine.argList[0])
            } else {
                verb = commandLine.argList[0]
                url = Some(commandLine.argList[1])
            }
        }
    }

    private fun buildOptions(): Options {

        val options = Options()

        options.addOption(
            builder("h")
            .argName("header")
            .hasArg()
            .desc("add a header")
            .longOpt("header")
            .build())


        return options
    }

    private fun isUrl(possibleUrl: String): Boolean {
        return possibleUrl.contains('.')
    }

}
