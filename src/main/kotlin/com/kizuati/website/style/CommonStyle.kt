package com.kizuati.website.style

import com.kizuati.website.StyleSheet

object CommonStyle : StyleSheet() {
    override val name = "common"

    override fun getMain(): String {
        return """
            
        """.trimIndent()
    }

    override fun getSmall() = """
        
    """.trimIndent()

    override fun getMobile() = """
        
    """.trimIndent()
}