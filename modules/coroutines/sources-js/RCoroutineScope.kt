package io.fluidsonic.react

import kotlinx.coroutines.*


@OptIn(kotlinx.coroutines.DelicateCoroutinesApi::class)
private val Context = React.context(GlobalScope + Dispatchers.Main.immediate)


/** Provides a [CoroutineScope] to child components via React context. */
public fun RBuilder.CoroutineScope(scope: CoroutineScope, content: RBuilder.() -> Unit) {
	Context.Provider(scope, content = content)
}


/** Returns the nearest [CoroutineScope] from the context hierarchy. */
public fun RHooks.useCoroutineScope(): CoroutineScope =
	useContext(Context)
