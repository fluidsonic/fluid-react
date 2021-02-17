import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":"))
				api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
			}
		}
	}
}
