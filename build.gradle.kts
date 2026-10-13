plugins {
    id("configuration.transitive_jar_in_jar")
    id("publishing.florianreuth")
}

dependencies {
    jarInJar(libs.tiny.mappings.parser)
    jarInJar(libs.reflect)
    jarInJar(libs.classtransform.core) {
        exclude(group = "org.ow2.asm", module = "asm")
        exclude(group = "org.ow2.asm", module = "asm-commons")
        exclude(group = "org.ow2.asm", module = "asm-tree")
        exclude(group = "org.ow2.asm", module = "asm-analysis")
    }
}
