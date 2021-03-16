fluid-react
===========

[![Maven Central](https://img.shields.io/maven-central/v/io.fluidsonic.react/fluid-react?label=Maven%20Central)](https://search.maven.org/artifact/io.fluidsonic.react/fluid-react)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.4.30%20(JS)-blue.svg)](https://github.com/JetBrains/kotlin/releases/v1.4.30)
[![React](https://img.shields.io/badge/React-17.0.1-blue.svg)](https://github.com/facebook/react/releases/tag/v17.0.1)
[![#fluid-libraries Slack Channel](https://img.shields.io/badge/slack-%23fluid--libraries-543951.svg?label=Slack)](https://kotlinlang.slack.com/messages/C7UDFSVT2/)

Kotlin/JS wrapper for [React](https://reactjs.org/), [React Router](https://reactrouter.com/) and
[react-helmet-async](https://github.com/staylor/react-helmet-async).

- Similar to [kotlin-react](https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react).
- Nicer and consistent API. Easier to use.
- Not multiplatform. Optimized for Kotlin/JS instead.
- No dependencies beside React.
- Lower size and performance overhead.
- More type safety, esp. around hooks.
- Props allow `class` instead of just `external interface`.
- Updates of local properties delegated with `by useState(…)` are reflected immediately.
- Support for coroutines with `CoroutineScope(…) { … }`, `useCoroutineScope()` and `useFlow(…)`.
- `@DslMarker` colors.
- **Experimental** and IR compiler only. Relies on compiler-internal behavior until [KT-10468](https://youtrack.jetbrains.com/issue/KT-10468) is solved.
- **Contributions welcome 😃**
- [Kotlin/JS-optimized CSS library](https://github.com/fluidsonic/fluid-css) with nice API in the works.

#### Notable differences in behavior

- Components created with `react.component()` are memoized by default unless they have children (`react.componentWithChildren()`).
- Memoization of components created with `react.component()` or added by `RComponent.memo()` use `equals()` to compare Props. You must ensure that your props
  implement `equals()` in order to benefit from memoization.
- Hook dependencies use `equals()` instead of `===`. They don't need to be an `Array` nor is the same amount of dependencies needed for each render.
- Router routes are `exact`, `strict` and `sensitive` by default.

## Installation

`build.gradle.kts`:

```kt
dependencies {
    implementation("io.fluidsonic.react:fluid-react-dom:0.9.8") // basis module

    implementation("io.fluidsonic.react:fluid-react-coroutines:0.9.8") // optional coroutine support
    implementation("io.fluidsonic.react:fluid-react-helmet:0.9.8")     // optional dynamic metadata (react-helmet-async)
    implementation("io.fluidsonic.react:fluid-react-router-dom:0.9.8") // optional routing (react-router)
}
```

## Example

```kt
import io.fluidsonic.react.*
import kotlinx.browser.*

fun main() {
    val body = checkNotNull(document.body)
    val container = document.createElement("div").also(body::appendChild)

    react.render(container) {
        +"Hello world"

        EmojiContainer(EmojiContainerProps("😍")) { strong { +"cool" } }
    }
}

val EmojiContainer by react.componentWithChildren { props: EmojiContainerProps, children ->
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
```

Also check out the [playground](modules/playground) and run it from IntelliJ IDEA.
