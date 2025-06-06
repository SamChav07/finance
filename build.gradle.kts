// 🔧 Plugins necesarios para Kotlin + Spring Boot + MapStruct
plugins {
	kotlin("jvm") version "1.9.25" // Soporte para Kotlin JVM
	kotlin("plugin.spring") version "1.9.25" // Integración con Spring Boot
	kotlin("plugin.jpa") version "1.9.25" // Soporte para JPA en Kotlin
	id("org.jetbrains.kotlin.kapt") version "1.9.25" // Soporte para anotaciones como MapStruct (Kotlin Annotation Processing Tool)
	id("org.springframework.boot") version "3.5.0" // Plugin Spring Boot
	id("io.spring.dependency-management") version "1.1.7" // Gestión de dependencias Spring
}

// 📦 Información general del proyecto
group = "com.finance"
version = "0.0.1-SNAPSHOT"

// ⚙ Configuración de Java: se usa Java 21
java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

// 🌍 Repositorio de dependencias
repositories {
	mavenCentral()
}

// 📚 Dependencias del proyecto
dependencies {
	// 🔁 MapStruct para generación automática de mappers
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")

	// ⚙ Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-web") // Web API
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") // JPA y ORM
	implementation("org.springframework.boot:spring-boot-starter-validation") // Bean Validation
	implementation("org.springframework.boot:spring-boot-starter-actuator") // Endpoints de monitoreo
	developmentOnly("org.springframework.boot:spring-boot-devtools") // Recarga automática en desarrollo

	// 🧠 Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect") // Reflexión en tiempo de ejecución
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Soporte Jackson para Kotlin

	// 🗄 Base de datos
	implementation("org.postgresql:postgresql") // Driver PostgreSQL
	runtimeOnly("org.postgresql:postgresql")

	// ✅ Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// 🧰 Procesador de configuración Spring (opcional pero útil)
	kapt("org.springframework.boot:spring-boot-configuration-processor")
}

// 🧠 Configuración de compilador Kotlin
kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict") // Mejor manejo de null safety
	}
}

// ⚙ Configuración de KAPT (procesador de anotaciones)
kapt {
	correctErrorTypes = true // Evita errores por tipos generados
}

// 🔓 Permite que las clases anotadas con estas anotaciones sean "open" (necesario para JPA con Kotlin)
allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

// 🧪 Configura pruebas con JUnit 5
tasks.withType<Test> {
	useJUnitPlatform()
}