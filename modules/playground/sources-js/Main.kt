import io.fluidsonic.react.*
import io.fluidsonic.react.helmet.*
import kotlinx.browser.*


fun main() {
	val body = checkNotNull(document.body)
	val container = document.createElement("div").also(body::appendChild)

	React.createRoot(container = container).render {
		StrictMode {
			HelmetProvider {
				Helmet(defaultTitle = "Playground", titleTemplate = "%s - Playground")

				+"Hello world"
				EmojiContainer(EmojiContainerProps("😍")) { strong { +"cool" } }
			}
		}
	}
}
