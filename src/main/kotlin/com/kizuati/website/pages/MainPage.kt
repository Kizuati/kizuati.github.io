package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import kotlinx.html.BODY

object MainPage : Page() {
    override val title = "Kizu's Landing Page"
    override val path = "index"

    override fun additionalStyleSheets(): List<StyleSheet> {
        return listOf(Style)
    }

    override fun BODY.body() {

    }

    object Style : StyleSheet() {
        override val name = "main_page"

        override fun getMain(): String {
            return """
                
            """.trimIndent()
        }

        override fun getSmall() = """
            
        """.trimIndent()

        override fun getMobile() = """
            
        """.trimIndent()
    }
}