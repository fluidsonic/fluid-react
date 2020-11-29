import io.fluidsonic.react.*
import kotlinx.browser.*


fun main() {
	val body = checkNotNull(document.body)
	val container = document.createElement("div").also(body::appendChild)

	react.render(container = container) {
		+"Hello world"

		EmojiContainer(EmojiContainerProps("😍")) { strong { +"cool" } }
	}
}
