pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "base_project"
include(":app")
include(":features:home")
include(":features:auth")
include(":features:profile")
include(":features:articles")
include(":core:design")
include(":core:model")
include(":core:network")
include(":core:data")
include(":core:domain")
