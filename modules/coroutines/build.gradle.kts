import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":"))
				api(kotlinx("coroutines-core", Versions.kotlinx_coroutines))
			}
		}
	}
}
