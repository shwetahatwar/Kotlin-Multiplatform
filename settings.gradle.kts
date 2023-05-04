pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin_multiplatform_app"
include(":androidApp")
include(":shared")
include(":kotlinmultiplatformsharedmodule")
