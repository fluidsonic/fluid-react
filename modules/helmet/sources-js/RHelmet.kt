package io.fluidsonic.react.helmet

import io.fluidsonic.react.*
import io.fluidsonic.react.helmet.external.*
import org.w3c.dom.*


@PublishedApi
internal external interface RHelmetProps : RProps.WithChildren {

	var defer: Boolean?
	var defaultTitle: String?
	var encodeSpecialCharacters: Boolean?
	var onChangeClientState: ((state: dynamic, addedTags: RHelmetTags, removedTags: RHelmetTags) -> Unit)? // TODO Fully specify type.
	var titleTemplate: String?
}


public external interface RHelmetTags {

	public val baseTag: Array<out HTMLBaseElement>
	public val linkTags: Array<out HTMLLinkElement>
	public val metaTags: Array<out HTMLMetaElement>
	public val noscriptTags: Array<out HTMLElement>
	public val scriptTags: Array<out HTMLScriptElement>
	public val styleTags: Array<out HTMLStyleElement>
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.Helmet(
	defaultTitle: String? = null,
	defer: Boolean? = null,
	encodeSpecialCharacters: Boolean? = null,
	noinline onChangeClientState: ((state: dynamic, addedTags: RHelmetTags, removedTags: RHelmetTags) -> Unit)? = null, // TODO Fully specify type.
	titleTemplate: String? = null,
	content: RBuilder.() -> Unit = {},
) {
	ReactHelmet_Helmet::class {
		defer?.let { attrs.defer = it }
		defaultTitle?.let { attrs.defaultTitle = it }
		encodeSpecialCharacters?.let { attrs.encodeSpecialCharacters = it }
		onChangeClientState?.let { attrs.onChangeClientState = it }
		titleTemplate?.let { attrs.titleTemplate = it }

		content()
	}
}
