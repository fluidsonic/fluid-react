@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

fluidLibraryModule(description = "React DOM bindings for fluid-react") {
	targets {
		js {
			dependencies {
				api(project(":"))

				implementation(npm("react-dom", Versions.react))
			}
		}
	}
}
