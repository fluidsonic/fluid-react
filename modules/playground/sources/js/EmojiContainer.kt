import io.fluidsonic.react.*
import kotlinx.browser.*


val EmojiContainer = react.componentWithChildren { props: EmojiContainerProps, children ->
	var count by useState(3)

	useEffect(count) {
		val timerId = window.setTimeout({ count += 1 }, 2000)

		cleanup { window.clearTimeout(timerId) }
	}

	h1 { +"Your emoji, $count times 🎉" }
	button {
		attrs.onClick = { count += 1 }
		+"Add one"
	}
	ol {
		repeat(count) {
			li {
				+props.emoji
				+" "
				children()
			}
		}
	}
}


class EmojiContainerProps(val emoji: String)
