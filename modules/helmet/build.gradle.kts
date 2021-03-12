import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":fluid-react-dom"))

				implementation(npm("react-helmet-async", "~1.0.9"))
			}
		}
	}
}
