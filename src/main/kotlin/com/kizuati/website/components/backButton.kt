package com.kizuati.website.components

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.FlowOrInteractiveOrPhrasingContent
import kotlinx.html.button

fun FlowOrInteractiveOrPhrasingContent.backButton() {
    button(ButtonFormEncType.applicationXWwwFormUrlEncoded, ButtonFormMethod.get, "backButton") {
        attributes["class"] = "backbutton"
        attributes["style"] = "width: 2em; height: 2em; background-color: #00000000; margin: 0; padding: 0; vertical-align: text-top; border: none; color: #FFFFFF;"
        attributes["onClick"] = "history.back();"
        +"\uD83E\uDC44"
    }
}