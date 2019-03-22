val logback_version: String by project
val kotlin_version: String by project
val spek_version: String by project
val jackson_version: String by project
val kluent_version: String by project
val arrow_version: String by project

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.21"
    kotlin("kapt") version "1.3.21"
}

allprojects {
    group = "com.knowledgespike"
    version = "0.0.1"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        jcenter()
        mavenLocal()
        maven { url = uri("https://dl.bintray.com/kotlin/kotlinx/") }
        maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
        maven { url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/") }
    }

    dependencies {
        implementation("ch.qos.logback:logback-classic:$logback_version")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")

        implementation( "io.arrow-kt:arrow-core-data:$arrow_version")

        testImplementation("org.amshove.kluent:kluent:$kluent_version")
        testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek_version")

        testRuntime("org.spekframework.spek2:spek-runner-junit5:$spek_version")
    }

    tasks.withType<Test> {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }

}

subprojects {
    version = "1.0"
}

project(":proksy-console") {
    dependencies {
        implementation(project(":proksy-core"))
    }
}

project(":proksy-core") {
}
