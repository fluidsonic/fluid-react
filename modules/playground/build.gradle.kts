import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

fluidLibraryModule(description = "FIXME") {
	withoutPublishing()

	language {
		withoutExplicitApi()
	}

	targets {
		js(KotlinJsCompilerType.IR) {
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
