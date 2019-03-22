import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val arrow_version: String by project

plugins {
    kotlin("jvm")
    kotlin("kapt")
}


dependencies {
    kapt    ("io.arrow-kt:arrow-meta:$arrow_version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
