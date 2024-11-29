@file:Suppress("SpellCheckingInspection")

plugins {
    application
    idea

    kotlin("jvm") version "+"
    id("com.gradleup.shadow") version "+"
    id("org.beryx.runtime") version "+"
}

group = "top.mioyi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:+")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("top.mioyi.MainKt")
}

idea.module {
    isDownloadSources = true
    isDownloadJavadoc = true
}

kotlin {
    jvmToolchain(21)
}

runtime {
    addModules("ALL-MODULE-PATH")

    jpackage {
        imageName = "KotlinTemplateProject"
        appVersion = version.toString()
        skipInstaller = true

        jvmArgs = listOf(
            "-Dfile.encoding=UTF-8",
            "-XX:+UseZGC",
            "-XX:+ZGenerational",
        )
    }
}