import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

plugins {
	id("io.fluidsonic.gradle") version "1.1.13"
}

fluidLibrary(name = "react", version = "0.9.0") {
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
	publishSingleTargetAsModule()

	targets {
		js(KotlinJsCompilerType.IR) {
			dependencies {
				implementation(npm("react", "~17.0.1"))
			}
		}
	}
}
