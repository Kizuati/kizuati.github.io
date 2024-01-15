package com.kizuati.website.components

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.style

inline fun FlowContent.split(justify: Justify, crossinline leftSide: DIV.() -> Unit, crossinline rightSide: DIV.() -> Unit, vararg extraClasses: String) {
    div(listOf("split", *extraClasses).joinToString(separator = " ")) {
        style = "justify-content: ${justify.css}"
        div { leftSide() }
        div { rightSide() }
    }
}

enum class Justify(val css: String) {
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around")
}