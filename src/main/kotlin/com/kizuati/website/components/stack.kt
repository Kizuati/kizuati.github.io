package com.kizuati.website.components

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.style

fun FlowContent.stack(justify: Justify, vararg extraClasses: String, builder: DIV.()->Unit) {
    div(listOf("stack", *extraClasses).joinToString(separator = " ")) {
        style = "justify-content: ${justify.css}"
        builder()
    }
}