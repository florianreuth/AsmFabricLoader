pluginManagement {
	repositories {
		mavenCentral()
		gradlePluginPortal()
        maven("https://maven.florianreuth.de/releases")
        maven("https://maven.fabricmc.net/")
	}

    plugins {
        id("fabric-loom") version "1.11-SNAPSHOT" // Keep this in order to support legacy fabric
        id("de.florianreuth.baseproject") version "2.0.0"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "asmfabricloader"

include("asmfabricloader-test-mod")

