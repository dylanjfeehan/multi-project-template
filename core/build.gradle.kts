val testJar = tasks.register("testJar", Jar::class.java) {
    from(sourceSets["test"].output)
    this.archiveClassifier.set("test")
}

val testConfig = configurations.create("testArtifacts") {
    extendsFrom(configurations["testApi"])
}

artifacts {
    add("testArtifacts", testJar)
}

dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin:${MockitoKotlin.version}")
}