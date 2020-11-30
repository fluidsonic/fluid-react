import io.fluidsonic.gradle.*
import org.jetbrains.kotlin.gradle.plugin.*

fluidLibraryModule(description = "FIXME") {
	publishSingleTargetAsModule()

	targets {
		js(KotlinJsCompilerType.IR) {
			dependencies {
				api(project(":"))

				implementation(npm("react-dom", "~17.0.1"))
			}
		}
	}
}
