import io.fluidsonic.react.*
import io.fluidsonic.react.helmet.*
import kotlinx.browser.*


fun main() {
	val body = checkNotNull(document.body)
	val container = document.createElement("div").also(body::appendChild)

	react.render(container = container) {
		StrictMode {
			HelmetProvider {
				Helmet(defaultTitle = "Playground", titleTemplate = "%s - Playground")

				+"Hello world"
				EmojiContainer(EmojiContainerProps("😍")) { strong { +"cool" } }
			}
		}
	}
}
