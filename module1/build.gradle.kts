import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    application
    java
    id("org.springframework.boot")
    id("com.github.davidmc24.gradle.plugin.avro") version "1.6.0"
    id("com.github.imflog.kafka-schema-registry-gradle-plugin") version "1.9.1"
    id("idea")
}

apply(plugin = "io.spring.dependency-management")

tasks.getByName<BootJar>("bootJar") {
    archiveClassifier.set("boot")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":module2"))
    implementation("org.springframework.boot:spring-boot-starter-web")


    // Kafka

    // Actuator
    runtimeOnly("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")

    // Config

    // structured logging

    testImplementation(project(":core", "testArtifacts"))
    //testImplementation(project(":module1", "testArtifacts"))

    // we love mockito
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}