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


// See https://kotlinlang.slack.com/archives/CRJCTR5PD/p1616079912009800
@RDsl
public fun <Value> RHooks.useFlow(flow: StateFlow<Value>): Value {
	val scope = useCoroutineScope()
	val (_, setValue) = useState(flow.value)

	useEffect(null) {
		cleanup(flow.onEach { setValue(it) }.launchIn(scope)::cancel)
	}

	return flow.value
}
