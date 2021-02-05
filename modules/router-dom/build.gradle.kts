import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":fluid-react-dom"))
				api(project(":fluid-react-router"))

				implementation(npm("react-router-dom", "~5.2.0"))
			}
		}
	}
}
