@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

fluidLibraryModule(description = "React Helmet Async bindings for fluid-react") {
	targets {
		js {
			dependencies {
				api(project(":fluid-react-dom"))

				implementation(npm("react-helmet-async", Versions.react_helmet_async))
			}
		}
	}
}
