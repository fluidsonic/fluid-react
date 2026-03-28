# fluid-react

Kotlin/JS wrapper library for React, React Router, and react-helmet-async.

## Commands

- Build: `./gradlew assemble`
- Test: `./gradlew jsTest`
- Check dependencies: `./gradlew dependencyUpdates`
- Update yarn.lock: `./gradlew kotlinUpgradeYarnLock`
- Run playground: `./gradlew :fluid-react-playground:jsBrowserDevelopmentRun`

## Source layout

- Root module sources: `sources-js/`
- Root module tests: `tests-js/`
- Submodule sources: `modules/<name>/sources-js/`
- Submodule tests: `modules/<name>/tests-js/`
- Build config: `buildSrc/sources/Versions.kt`
- Webpack config: `modules/playground/webpack.config.d/`

## Architecture

- Package: `io.fluidsonic.react` (root), `io.fluidsonic.react.router`, `io.fluidsonic.react.helmet`
- `external interface` types wrap React JS objects
- `inline` functions provide type-safe Kotlin DSL over React APIs
- `@RDsl` marker annotation provides DSL scope control (types only, not functions)
- Component creation via `React.component()` / `React.componentWithChildren()`
- Hook access via `RHooks` extension functions
- Builder pattern: `RBuilder` -> `RElementBuilder` -> React elements

## Modules

| Module | Description |
|--------|-------------|
| Root | Core React types, hooks, component creation, element building |
| `dom` | React DOM bindings (createRoot, HTML tags, SVG) |
| `coroutines` | CoroutineScope provider and useFlow hooks |
| `helmet` | react-helmet-async bindings |
| `router` | React Router core bindings |
| `router-dom` | React Router DOM bindings (BrowserRouter, HashRouter) |
| `playground` | Non-published demo app |

## Conventions

- Tab indentation
- Explicit API mode (all modules except playground)
- `@Suppress("NOTHING_TO_INLINE")` on inline functions used for unsafeCast
- External JS bindings in `utility/External.kt` files with `@PublishedApi internal`
- JS module files annotated with `@file:JsModule("...")`
- `@file:Suppress("DEPRECATION")` in all build.gradle.kts files (JS target deprecated in fluid-gradle 3.0.0)
- Tags have no `v` prefix (e.g. `0.14.0`, not `v0.14.0`)
- `kotlin-js-store/yarn.lock` MUST be committed for reproducible JS builds
