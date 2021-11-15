import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.24"
	id("com.github.turansky.kfc.latest-webpack") version "4.41.0" // https://youtrack.jetbrains.com/issue/KT-49124
}

fluidLibrary(name = "react", version = "0.11.1") {
	allModules {
		targets {
			js {
				custom {
					useCommonJs()
				}
			}
		}
	}
}

fluidLibraryModule(description = "Kotlin/JS wrapper for React") {
	targets {
		js {
			dependencies {
				implementation(npm("react", Versions.react))
			}
		}
	}
}
