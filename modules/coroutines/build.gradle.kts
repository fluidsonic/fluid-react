@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*

fluidLibraryModule(description = "Coroutine support for fluid-react") {
	targets {
		js {
			dependencies {
				api(project(":"))
				api(kotlinx("coroutines-core", Versions.kotlinx_coroutines))
			}
		}
	}
}
