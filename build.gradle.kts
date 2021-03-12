import io.fluidsonic.gradle.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.21"
}

fluidLibrary(name = "react", version = "0.9.8") {
	allModules {
		targets {
			js {
				custom {
					compilations.all {
						kotlinOptions.moduleKind = "commonjs"
					}
				}
			}
		}
	}
}

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				implementation(npm("react", "~17.0.1"))
			}
		}
	}
}
