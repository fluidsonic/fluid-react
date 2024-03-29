import io.fluidsonic.gradle.*

fluidLibraryModule(description = "FIXME") {
	withoutPublishing()

	language {
		withoutExplicitApi()
	}

	targets {
		js {
			withoutNodeJs()

			dependencies {
				api(project(":fluid-react-helmet"))
				api(project(":fluid-react-router-dom"))

				implementation(devNpm("html-webpack-plugin", "~5.3.2"))
			}

			custom {
				binaries.executable()
			}
		}
	}
}
