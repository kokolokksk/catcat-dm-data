import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.6.0"
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	mainClass.set("monster.loli.catcatdmdata.CatCatDmDataApplicationKt")
}
group = "monster.loli"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_19

repositories {
	maven { url = uri("https://maven.aliyun.com/repository/public/") }
	maven { url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
	maven { url = uri("https://maven.aliyun.com/repository/spring") }
	maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
	maven { url = uri("https://maven.aliyun.com/repository/central") }
	maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
	maven { url = uri("https://maven.aliyun.com/repository/apache-snapshots") }
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("junit:junit:4.13.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.squareup.okhttp3:okhttp:4.9.3")
	implementation ("com.google.code.gson:gson:2.9.0")
	// https://mvnrepository.com/artifact/org.apache.commons/commons-compress
	implementation("org.apache.commons:commons-compress:1.21")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "19"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
