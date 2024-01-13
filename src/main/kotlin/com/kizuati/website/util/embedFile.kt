package com.kizuati.website.util

import com.kizuati.website.pages.MainPage

fun embedFile(resourcePath: String): String {
    val stream = MainPage.javaClass.getResourceAsStream("/${resourcePath.removePrefix("/")}")
    require(stream != null) { "Failed to embed file: could not locate resource $resourcePath" }
    val out = stream.readAllBytes().decodeToString()
    stream.close()
    return out
}