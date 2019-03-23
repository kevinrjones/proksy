import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val arrow_version: String by project


plugins {
}


dependencies {

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
