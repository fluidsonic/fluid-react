import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":fluid-react-dom"))
				api(project(":fluid-react-router"))

				implementation(npm("react-router-dom", Versions.react_router))
			}
		}
	}
}
