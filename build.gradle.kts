import de.florianreuth.baseproject.integration.configureJarInJar
import de.florianreuth.baseproject.integration.includeTransitiveJijDependencies
import de.florianreuth.baseproject.integration.setupFabric
import de.florianreuth.baseproject.setupProject
import de.florianreuth.baseproject.setupPublishing

plugins {
    id("net.fabricmc.fabric-loom")
    id("de.florianreuth.baseproject")
}

allprojects {

    setupProject()
    setupFabric()

}

setupPublishing()

val shade = configureJarInJar()

repositories {
    maven("https://maven.lenni0451.net/everything")
}

dependencies {
    shade("net.fabricmc:tiny-mappings-parser:0.3.0+build.17")
    shade("net.lenni0451:Reflect:1.6.4")
    shade("net.lenni0451.classtransform:core:1.15.1") {
        exclude(group = "org.ow2.asm", module = "asm")
        exclude(group = "org.ow2.asm", module = "asm-commons")
        exclude(group = "org.ow2.asm", module = "asm-tree")
        exclude(group = "org.ow2.asm", module = "asm-analysis")
    }

    includeTransitiveJijDependencies()
}
