@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "3.0.0"
}

fluidLibrary(name = "react", version = "0.14.0") {
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
