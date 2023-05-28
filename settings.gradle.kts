rootProject.name = "multi-module-template"

//?? what does this do
include("core", "module1", "module2")

// sure
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://packages.confluent.io/maven/")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }
}