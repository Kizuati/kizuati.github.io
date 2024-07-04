package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.Justify
import com.kizuati.website.components.split
import kotlinx.html.*

object SocialPage : Page() {
    override val path = "social"

    override fun BODY.body() {
        h1 { +"Socials" }
        h2 { +"All of these are real,official socials by me. If it's not here it's probably a cake/lie." }
		h2 { +"If you're looking to contact me,I recommend you to email me instead at commissions@kizuati.com" }
        split(Justify.SPACE_AROUND, "links") {
            ul {
                entry(
                    "Twitch",
                    "https://kizuati.com/twitch",
                    "#6441a5",
                    "M391.2 103.5H352.5v109.7h38.6zM285 103H246.4V212.8H285zM120.8 0 24.3 91.4V420.6H140.1V512l96.5-91.4h77.3L487.7 256V0zM449.1 237.8l-77.2 73.1H294.6l-67.6 64v-64H140.1V36.6H449.1z"
                )
                entry(
                    "Youtube",
                    "https://kizuati.com/youtube",
                    "#FF0000",
                    "M549.7 124.1c-6.3-23.7-24.8-42.3-48.3-48.6C458.8 64 288 64 288 64S117.2 64 74.6 75.5c-23.5 6.3-42 24.9-48.3 48.6-11.4 42.9-11.4 132.3-11.4 132.3s0 89.4 11.4 132.3c6.3 23.7 24.8 41.5 48.3 47.8C117.2 448 288 448 288 448s170.8 0 213.4-11.5c23.5-6.3 42-24.2 48.3-47.8 11.4-42.9 11.4-132.3 11.4-132.3s0-89.4-11.4-132.3zm-317.5 213.5V175.2l142.7 81.2-142.7 81.2z"
                )
            }
            ul {
                entry(
                    "Twitter",
                    "https://kizuati.com/twitter",
                    "#1D9BF0",
                    "M459.4 151.7c.3 4.5 .3 9.1 .3 13.6 0 138.7-105.6 298.6-298.6 298.6-59.5 0-114.7-17.2-161.1-47.1 8.4 1 16.6 1.3 25.3 1.3 49.1 0 94.2-16.6 130.3-44.8-46.1-1-84.8-31.2-98.1-72.8 6.5 1 13 1.6 19.8 1.6 9.4 0 18.8-1.3 27.6-3.6-48.1-9.7-84.1-52-84.1-103v-1.3c14 7.8 30.2 12.7 47.4 13.3-28.3-18.8-46.8-51-46.8-87.4 0-19.5 5.2-37.4 14.3-53 51.7 63.7 129.3 105.3 216.4 109.8-1.6-7.8-2.6-15.9-2.6-24 0-57.8 46.8-104.9 104.9-104.9 30.2 0 57.5 12.7 76.7 33.1 23.7-4.5 46.5-13.3 66.6-25.3-7.8 24.4-24.4 44.8-46.1 57.8 21.1-2.3 41.6-8.1 60.4-16.2-14.3 20.8-32.2 39.3-52.6 54.3z"
                )
                entry(
                    "Discord",
                    "https://kizuati.com/discord",
                    "#5865F2",
                    "M524.5 69.8a1.5 1.5 0 0 0 -.8-.7A485.1 485.1 0 0 0 404.1 32a1.8 1.8 0 0 0 -1.9 .9 337.5 337.5 0 0 0 -14.9 30.6 447.8 447.8 0 0 0 -134.4 0 309.5 309.5 0 0 0 -15.1-30.6 1.9 1.9 0 0 0 -1.9-.9A483.7 483.7 0 0 0 116.1 69.1a1.7 1.7 0 0 0 -.8 .7C39.1 183.7 18.2 294.7 28.4 404.4a2 2 0 0 0 .8 1.4A487.7 487.7 0 0 0 176 479.9a1.9 1.9 0 0 0 2.1-.7A348.2 348.2 0 0 0 208.1 430.4a1.9 1.9 0 0 0 -1-2.6 321.2 321.2 0 0 1 -45.9-21.9 1.9 1.9 0 0 1 -.2-3.1c3.1-2.3 6.2-4.7 9.1-7.1a1.8 1.8 0 0 1 1.9-.3c96.2 43.9 200.4 43.9 295.5 0a1.8 1.8 0 0 1 1.9 .2c2.9 2.4 6 4.9 9.1 7.2a1.9 1.9 0 0 1 -.2 3.1 301.4 301.4 0 0 1 -45.9 21.8 1.9 1.9 0 0 0 -1 2.6 391.1 391.1 0 0 0 30 48.8 1.9 1.9 0 0 0 2.1 .7A486 486 0 0 0 610.7 405.7a1.9 1.9 0 0 0 .8-1.4C623.7 277.6 590.9 167.5 524.5 69.8zM222.5 337.6c-29 0-52.8-26.6-52.8-59.2S193.1 219.1 222.5 219.1c29.7 0 53.3 26.8 52.8 59.2C275.3 311 251.9 337.6 222.5 337.6zm195.4 0c-29 0-52.8-26.6-52.8-59.2S388.4 219.1 417.9 219.1c29.7 0 53.3 26.8 52.8 59.2C470.7 311 447.5 337.6 417.9 337.6z"
                )
            }
        }
    }

    private fun UL.entry(text: String, link: String, fill: String, icon: String) {
        li {
            a(link, classes = "icon_link") {
                button {
                    svg("icon") {
                        attributes["aria-hidden"] = "true"
                        attributes["focusable"] = "false"
                        attributes["viewBox"] = "0 0 630 530"
                        unsafe {
                            +"<path fill=\"$fill\" d=\"$icon\"/>"
                        }
                    }
                    +text
                }
            }
        }
    }

    override fun additionalStyleSheets(): List<StyleSheet> {
        return listOf(Style)
    }

    object Style : StyleSheet() {
        override val name = "social_page"

        override fun getMain(): String {
            return """
                body {
                    margin: 0px 0px 0px 1em;
                }
                
                .icon {
                  width: 1em;
                  height: 1em;
                  vertical-align: -0.125em;
                }
                
                .icon_link:link {
                      text-decoration: none;
                }

                .icon_link:visited {
                      text-decoration: none;
                }

                .icon_link:hover {
                      text-decoration: none;
                }

                .icon_link:active {
                      text-decoration: none;
                }
                
                button {
                    border: none;
                    border-radius: 10px;
                    padding: 5px;
                    text-align: center;
                    display: inline-block;
                    font-size: 16px;
                    margin: 4px 2px;
                    width: 6em;
                    background-color: #2f2f33;
                    color: #FFFFFF;
                }
                
                ul {
                    list-style-type: none;
                    padding: 0;
                    margin: 0;
                }
                
                .links {
                    max-width: 14em;
                }
            """.trimIndent()
        }
    }
}