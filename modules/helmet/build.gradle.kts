import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	targets {
		js {
			dependencies {
				api(project(":fluid-react-dom"))

				implementation(npm("react-helmet-async", Versions.react_helmet_async))
			}
		}
	}
}
