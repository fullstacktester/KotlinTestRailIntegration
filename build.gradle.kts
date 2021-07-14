plugins {
    kotlin("jvm") version "1.5.20"
    `java-library`
    id("io.kotest") version "0.2.6"
    id("maven-publish")
    kotlin("plugin.serialization") version "1.5.20"
}

group="uk.co.fullstacktesting"
version=1.0

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib-jdk8:1.5.20"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-kotlinx-serialization:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-json:2.3.1")
    implementation("io.github.config4k:config4k:0.4.2")
    implementation("com.typesafe:config:1.4.0")

    implementation(kotlin("reflect:1.5.10"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("io.kotest:kotest-runner-junit5:4.2.5")
    implementation("io.kotest:kotest-assertions-core:4.2.5")
    implementation("io.kotest:kotest-assertions-json:4.2.5")
    implementation(platform("org.junit:junit-bom:5.7.0"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("io.mockk:mockk:1.9.2") // https://github.com/mockk/mockk/issues/280
    implementation("com.willowtreeapps.assertk:assertk-jvm:0.23")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2")
    implementation("io.ktor:ktor-client-mock:1.5.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.jar {
    manifest {
        attributes(mapOf("Implementation-Title" to project.name,
            "Implementation-Version" to project.version))
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}