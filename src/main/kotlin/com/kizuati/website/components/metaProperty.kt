package com.kizuati.website.components

import kotlinx.html.HEAD
import kotlinx.html.meta

fun HEAD.metaProperty(property: String, content: String) {
    meta(content = content) {
        attributes["property"] = property
    }
}