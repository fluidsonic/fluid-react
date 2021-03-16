package io.fluidsonic.react

import kotlinx.coroutines.*


private val Context = react.context<CoroutineScope>(GlobalScope)


@RDsl
public fun RBuilder.CoroutineScope(scope: CoroutineScope, content: RBuilder.() -> Unit) {
	Context.Provider(scope, content = content)
}


@RDsl
public fun RHooks.useCoroutineScope(): CoroutineScope =
	useContext(Context)
