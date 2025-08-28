plugins {
    id("java")
    id("org.springframework.boot") version "3.5.5"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "fr.aerow.training"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // La super lib programmation fonctionnelle
    implementation("io.vavr:vavr:0.10.5")
    // spring
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // pour tester les webservices quand démarré
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    // junit notamment pour le tdd
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // de qui se mock-t-on !
    testImplementation("org.mockito:mockito-core:5.19.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(24))
    }
}
