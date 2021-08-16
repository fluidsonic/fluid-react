import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.24"
}

fluidLibrary(name = "react", version = "0.11.0") {
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
