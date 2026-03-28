@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

fluidLibraryModule(description = "React Router DOM bindings for fluid-react") {
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
