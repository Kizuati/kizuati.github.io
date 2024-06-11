package com.kizuati.website

import com.kizuati.website.style.CommonStyle
import kotlinx.html.BODY
import kotlinx.html.HEAD
import kotlinx.html.script
import kotlinx.html.unsafe

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
    open fun BODY.postBody() {
        script(src = "https://storage.ko-fi.com/cdn/scripts/overlay-widget.js") {}
        script {
            unsafe {
                +"""
                kofiWidgetOverlay.draw('kizuaxiosov', {
                    'type': 'floating-chat',
                    'floating-chat.donateButton.text': 'Tip Me',
                    'floating-chat.donateButton.background-color': '#ff5f5f',
                    'floating-chat.donateButton.text-color': '#fff'
                });
                """.trimIndent()
            }
        }
    }
}