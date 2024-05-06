plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "Fake implementations for epsilon-core"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }
//    if (Targeting.WASM) wasmWasi { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()
    val nativeTargets = osxTargets + linuxTargets

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.epsilonCore)
                api(projects.epsilonFile)
            }
        }

        val commonTest by getting {
            dependencies {
                api(libs.koncurrent.later.test)
                implementation(libs.kommander.coroutines)
            }
        }

        val wasmMain by creating {
            dependsOn(commonMain)
        }

        if(Targeting.WASM) {
            val wasmJsMain by getting {
                dependsOn(wasmMain)
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        nativeTargets.forEach {
            val main by it.compilations.getting {}
            main.defaultSourceSet {
                dependsOn(nativeMain)
            }
        }
    }
}
