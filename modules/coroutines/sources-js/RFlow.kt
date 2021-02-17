package io.fluidsonic.react

import kotlinx.coroutines.flow.*


@RDsl
public fun <Value> RHooks.useFlow(flow: Flow<Value>, initialValue: Value): Value {
	val scope = useCoroutineScope()
	var value by useState(initialValue)

	useEffect(null) {
		cleanup(flow.onEach { value = it }.launchIn(scope)::cancel)
	}

	return value
}


@RDsl
public fun <Value> RHooks.useFlow(flow: StateFlow<Value>): Value =
	useFlow(flow, initialValue = flow.value)
