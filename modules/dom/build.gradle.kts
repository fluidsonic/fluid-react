import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":"))

				implementation(npm("react-dom", "~17.0.1"))
			}
		}
	}
}
