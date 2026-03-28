@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

fluidLibraryModule(description = "React Router bindings for fluid-react") {
	targets {
		js {
			dependencies {
				api(project(":"))

				implementation(npm("react-router", Versions.react_router))
			}
		}
	}
}
