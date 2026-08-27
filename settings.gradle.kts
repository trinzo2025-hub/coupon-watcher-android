pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Repositorio de Chaquopy (intérprete de Python embebido en la app)
        maven("https://chaquo.com/maven")
    }
}

rootProject.name = "CouponWatcher"
include(":app")
