import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":"))

				implementation(npm("react-router", Versions.react_router))
			}
		}
	}
}
