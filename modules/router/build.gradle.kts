import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":"))

				implementation(npm("react-router", "~5.2.0"))
			}
		}
	}
}
