package com.kizuati.website.components

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.style

fun FlowContent.split(justify: Justify, vararg extraClasses: String, builder: DIV.() -> Unit) {
    div(listOf("split", *extraClasses).joinToString(separator = " ")) {
        style = "justify-content: ${justify.css}"
        builder()
    }
}

enum class Justify(val css: String) {
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    SPACE_EVENLY("space-evenly")
}