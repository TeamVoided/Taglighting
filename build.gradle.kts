@file:Suppress("PropertyName", "VariableNaming")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.iridium)
    alias(libs.plugins.iridium.publish)
    alias(libs.plugins.iridium.upload)
}

repositories {
    maven("https://teamvoided.org/releases")
    maven("https://teamvoided.org/snapshots")
    maven("https://maven.terraformersmc.com/") { name = "Terraformers" }
    maven("https://maven.fzzyhmstrs.me/") { name = "FzzyMaven" }
    maven("https://api.modrinth.com/maven")
    mavenCentral()
}

println("Task: " + gradle.startParameter.taskNames.joinToString(","))

modSettings {
    entrypoint("main", "org.teamvoided.taglighting.Taglighting::init")
    entrypoint("fabric-datagen", "org.teamvoided.taglighting.data.gen.TaglightingData")

    mixinFile("${modId()}.mixins.json")
    accessWidener("${modId()}.accesswidener")

//    entrypoint("client", "org.teamvoided.taglighting.TaglightingClient::init")
//    mixinFile("${modId()}.client.mixins.json")
}

dependencies {
    // QoL
    modImplementation(libs.modmenu)
    modCompileOnly("${libs.emi.get()}:api")
    modLocalRuntime(libs.emi)
    // Dev
    modImplementation(libs.devin)
    modImplementation(libs.creative.works)
    modImplementation(libs.fzzy.config)
    modImplementation(libs.imguimc)
}

val username = "vDev"
val uuid: String? = null
loom {
    splitEnvironmentSourceSets()
    runs {
        named("client") {
            programArgs("--username", username)
            uuid?.let { programArgs("--uuid", uuid) }
        }

        create("TestWorld") {
            client()
            ideConfigGenerated(true)
            runDir("run")
            programArgs("--quickPlaySingleplayer", "test", "--username", username)
            uuid?.let { programArgs("--uuid", uuid) }
        }

        create("DataGen") {
            client()
            ideConfigGenerated(true)
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.modid=${modSettings.modId()}")
            runDir("build/datagen")
        }
    }
}

sourceSets["main"].resources.srcDir("src/main/generated")

tasks {
    val targetJavaVersion = 21
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile>().all {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
    jar {
        val valTaskNames = gradle.startParameter.taskNames
        if (!valTaskNames.contains("runDataGen")) {
            exclude("org/teamvoided/template/data/gen/*")
        } else {
            println("Running datagen for task ${valTaskNames.joinToString(" ")}")
        }
    }
}

publishScript {
    releaseRepository("TeamVoided", "https://maven.teamvoided.org/releases")
    publication(modSettings.modId(), false)
    publishSources(true)
}

uploadConfig {
//    debugMode = true
    modrinthId = "x"
    curseId = "0"

    // FabricApi
    modrinthDependency("P7dR8mSH", uploadConfig.REQUIRED)
    curseDependency("fabric-api", uploadConfig.REQUIRED)
    // Fabric Language Kotlin
    modrinthDependency("Ha28R6CL", uploadConfig.REQUIRED)
    curseDependency("fabric-language-kotlin", uploadConfig.REQUIRED)
}
