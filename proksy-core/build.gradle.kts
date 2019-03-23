import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val arrow_version: String by project
val apache_commons_cli_version: String by project

plugins {
    kotlin("jvm")
    kotlin("kapt")
}


dependencies {
    implementation("commons-cli:commons-cli:$apache_commons_cli_version")

    kapt    ("io.arrow-kt:arrow-meta:$arrow_version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
