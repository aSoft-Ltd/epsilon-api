pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "kommander", "kase", "kotlinx-interoperable", "cinematic", "status"
).forEach { includeBuild("../$it") }

rootProject.name = "epsilon-api"

includeSubs("epsilon", ".", "core")
