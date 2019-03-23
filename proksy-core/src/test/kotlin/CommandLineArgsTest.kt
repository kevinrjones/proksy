package com.knowledgespike.proksy.core

import org.amshove.kluent.`should be equal to`
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


object CommandLineArgsSpec : Spek({

    val someUrl = "test.local"
    val aFlag = "-h header"

    describe("Get the verb") {
        it("should get the verb when there are no flags and the verb is set") {
            val cli = CommandLineArgs(arrayOf("POST", someUrl))

            cli.verb.`should be equal to`("POST")
        }

        it("should get the verb when there are no flags and the verb is not set") {
            val cli = CommandLineArgs(arrayOf(someUrl))

            cli.verb.`should be equal to`("GET")
        }

        it("should get the verb when there is one flag and the verb is set") {
            val cli = CommandLineArgs(arrayOf(aFlag, "POST", someUrl))

            cli.verb.`should be equal to`("POST")
        }

    }
})