import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.3.2"
	id("com.github.turansky.kfc.latest-webpack") version "4.88.0" // https://youtrack.jetbrains.com/issue/KT-49124
}

fluidLibrary(name = "react", version = "0.12.0") {
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
