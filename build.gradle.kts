plugins {
    kotlin("jvm") version "1.5.20"
    `java-library`
    id("io.kotest") version "0.2.6"
    id("maven-publish")
    id("signing")
    kotlin("plugin.serialization") version "1.5.20"

}

group="io.github.fullstacktester"
version=1.0
description="A Kotlin utility for uploading test results to TestRail"

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

java {
    withSourcesJar()
    withJavadocJar()
}

signing {
    sign("configurations.archives")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
    getByName("test").java.srcDirs("src/main/kotlin")
}


publishing {
    publications {
        register(project.name, MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar)
            artifact(javadocJar)

            groupId = groupId
            artifactId = project.name
            version = version

            repositories {
                maven {
                    name = "snapshot"
                    url = java.net.URI("")

                }
            }



            pom {
                name.set(project.name)
                description.set(project.description)

                packaging = if (project.hasProperty("android")) "aar" else "jar"
                url.set("https://github.com/fullstacktester/KotlinTestRailIntegration")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        name.set("fullstacktester")
                    }
                }

                scm {
                    url.set("https://github.com/fullstacktester/KotlinTestRailIntegration")
                    connection.set("scm:git:git://github.com/fullstacktester/KotlinTestRailIntegration")
                    developerConnection.set("scm:git:git://github.com/fullstacktester/KotlinTestRailIntegration")
                }
            }

            if (project.hasProperty("android")) {
                pom.addDependencies()
            }
        }
    }
}




