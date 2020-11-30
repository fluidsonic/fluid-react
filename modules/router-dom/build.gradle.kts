import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

fluidLibraryModule(description = "FIXME") {
	publishSingleTargetAsModule()

	targets {
		js(KotlinJsCompilerType.IR) {
			dependencies {
				api(project(":fluid-react-dom"))
				api(project(":fluid-react-router"))

				implementation(npm("react-router-dom", "~5.2.0"))
			}
		}
	}
}
