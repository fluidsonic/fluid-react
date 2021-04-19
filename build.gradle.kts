import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.22"
}

fluidLibrary(name = "react", version = "0.10.1") {
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
