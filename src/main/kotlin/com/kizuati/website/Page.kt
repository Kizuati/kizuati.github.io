package com.kizuati.website

import com.kizuati.website.style.CommonStyle
import kotlinx.html.BODY
import kotlinx.html.HEAD

abstract class Page {
    abstract val path: String
    open val title: String = "Kizu's Website"
    open val description = "Do people read embeds instead of opening the site?"
    open fun styleSheets(): List<StyleSheet> {
        return mutableListOf<StyleSheet>(
            CommonStyle
        ).also { it.addAll(additionalStyleSheets()) }
    }
    open fun additionalStyleSheets(): List<StyleSheet> = emptyList()
    open fun HEAD.head() {}
    open fun BODY.preBody() {}
    abstract fun BODY.body()
    open fun BODY.postBody() {}
}