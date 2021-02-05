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
				api(project(":fluid-react-router-dom"))

				implementation(devNpm("html-webpack-plugin", "~4.5.0"))
			}

			custom {
				binaries.executable()
			}
		}
	}
}
