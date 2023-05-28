dependencies {
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":core", "testArtifacts"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:${MockitoKotlin.version}")
}
