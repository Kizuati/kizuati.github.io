package com.kizuati.website

abstract class StyleSheet {
    abstract val name: String
    abstract fun getMain(): String
    open fun getSmall(): String? = null
    open fun getMobile(): String? = null

    fun assemble(): String {
        return buildString {
            append(getMain())
            val small = getSmall()
            if (small != null) {
                append("\n\n")
                append("@media screen and (max-width: 900px) {\n")
                append(small.lines().map { "\t$it" }.joinToString(prefix = "", postfix = "", separator = "\n"))
                append("\n}")
            }
            val mobile = getMobile()
            if (mobile != null) {
                append("\n\n")
                append("@media screen and (max-width: 530px) {\n")
                append(mobile.lines().map { "\t$it" }.joinToString(prefix = "", postfix = "", separator = "\n"))
                append("\n}")
            }
        }
    }
}