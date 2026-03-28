@file:Suppress("DEPRECATION")

import io.fluidsonic.gradle.*
import org.gradle.api.file.DuplicatesStrategy

// HtmlWebpackPlugin in webpack.config.d/index.js also produces index.html,
// which duplicates the one copied from resources-js/.
tasks.withType<AbstractCopyTask> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

fluidLibraryModule(description = "Demo & playground app for fluid-react") {
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

				implementation(devNpm("html-webpack-plugin", Versions.html_webpack_plugin))
			}

			custom {
				binaries.executable()
			}
		}
	}
}
