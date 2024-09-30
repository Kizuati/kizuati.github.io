package com.kizuati.website.style

import com.kizuati.website.StyleSheet

object CommonStyle : StyleSheet() {
    override val name = "common"

    override fun getMain(): String {
        return """
            html {
                background-color: #0c0c0d;
            }
            
            body {
                color: #FFFFFF;
                font-family: 'Rubik', sans-serif;
            }
            
            a {
                color: #83cbfc;
            }
            
            .split {
                display: flex;
            }
            
            .stack {
                display: flex;
                flex-direction: column;
             }
            
            .grid {
              display: grid;
              gap: 1rem;
              grid-template-columns: repeat(auto-fit, minmax(480px, 1fr));
            }
            
            .grid-item {
                display: flex;
                align-items: center;
                justify-content: center;
            }
            
            .vertical_divider {
                border: solid #2f2f33;
                border-width: 2px;
                margin: 0 10px 0 10px;
            }
        """.trimIndent()
    }

    override fun getSmall() = """
        
    """.trimIndent()

    override fun getMobile() = """
        .split {
            flex-direction: column;
            align-items: center;
        }
    """.trimIndent()
}