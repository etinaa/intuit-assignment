import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("ru.vyarus.quality") version "5.0.0"
	id("com.netflix.nebula.integtest-standalone") version "10.1.5"
	jacoco
}

group = "com.github.etinaa"
version = System.getProperty("build.number", "unspecified")

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	val springBootVersion = "3.2.2"

	implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-actuator:$springBootVersion")

	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	// CSV
	implementation("com.opencsv:opencsv:5.9")

	// Database
	implementation("org.postgresql:postgresql:42.7.1")
	implementation("org.liquibase:liquibase-core:4.26.0")

	// MapStruct
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

	// Metrics
	implementation("io.micrometer:micrometer-registry-prometheus:1.12.3")

	// Swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
	testImplementation("com.h2database:h2:2.2.224")

	val tetcontainersVersion = "1.19.5"

	integTestImplementation("org.springframework.boot:spring-boot-testcontainers:$springBootVersion")
	integTestImplementation("org.testcontainers:junit-jupiter:$tetcontainersVersion")
	integTestImplementation("org.testcontainers:postgresql:$tetcontainersVersion")
}

springBoot {
	buildInfo()
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<BootBuildImage>("bootBuildImage") {
	imageName.set("com.github.etinaa/${project.name}:${project.version}")
}