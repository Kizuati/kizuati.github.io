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
                    "https://twitch.tv/theKizuati",
                    "#6441a5",
                    "M391.2 103.5H352.5v109.7h38.6zM285 103H246.4V212.8H285zM120.8 0 24.3 91.4V420.6H140.1V512l96.5-91.4h77.3L487.7 256V0zM449.1 237.8l-77.2 73.1H294.6l-67.6 64v-64H140.1V36.6H449.1z"
                )
                entry(
                    "Youtube",
                    "https://youtube.com/@notkizuati",
                    "#FF0000",
                    "M549.7 124.1c-6.3-23.7-24.8-42.3-48.3-48.6C458.8 64 288 64 288 64S117.2 64 74.6 75.5c-23.5 6.3-42 24.9-48.3 48.6-11.4 42.9-11.4 132.3-11.4 132.3s0 89.4 11.4 132.3c6.3 23.7 24.8 41.5 48.3 47.8C117.2 448 288 448 288 448s170.8 0 213.4-11.5c23.5-6.3 42-24.2 48.3-47.8 11.4-42.9 11.4-132.3 11.4-132.3s0-89.4-11.4-132.3zm-317.5 213.5V175.2l142.7 81.2-142.7 81.2z"
                )
            }
            ul {
                entry(
                    "Twitter",
                    "https://twitter.com/kizuati",
                    "#1D9BF0",
                    "M459.4 151.7c.3 4.5 .3 9.1 .3 13.6 0 138.7-105.6 298.6-298.6 298.6-59.5 0-114.7-17.2-161.1-47.1 8.4 1 16.6 1.3 25.3 1.3 49.1 0 94.2-16.6 130.3-44.8-46.1-1-84.8-31.2-98.1-72.8 6.5 1 13 1.6 19.8 1.6 9.4 0 18.8-1.3 27.6-3.6-48.1-9.7-84.1-52-84.1-103v-1.3c14 7.8 30.2 12.7 47.4 13.3-28.3-18.8-46.8-51-46.8-87.4 0-19.5 5.2-37.4 14.3-53 51.7 63.7 129.3 105.3 216.4 109.8-1.6-7.8-2.6-15.9-2.6-24 0-57.8 46.8-104.9 104.9-104.9 30.2 0 57.5 12.7 76.7 33.1 23.7-4.5 46.5-13.3 66.6-25.3-7.8 24.4-24.4 44.8-46.1 57.8 21.1-2.3 41.6-8.1 60.4-16.2-14.3 20.8-32.2 39.3-52.6 54.3z"
                )
                entry(
                    "Bluesky",
                    "https://bsky.app/profile/kizu.bsky.social",
                    "#1486FC",
                    "M407.8 294.7c-3.3-.4-6.7-.8-10-1.3c3.4 .4 6.7 .9 10 1.3zM288 227.1C261.9 176.4 190.9 81.9 124.9 35.3C61.6-9.4 37.5-1.7 21.6 5.5C3.3 13.8 0 41.9 0 58.4S9.1 194 15 213.9c19.5 65.7 89.1 87.9 153.2 80.7c3.3-.5 6.6-.9 10-1.4c-3.3 .5-6.6 1-10 1.4C74.3 308.6-9.1 342.8 100.3 464.5C220.6 589.1 265.1 437.8 288 361.1c22.9 76.7 49.2 222.5 185.6 103.4c102.4-103.4 28.1-156-65.8-169.9c-3.3-.4-6.7-.8-10-1.3c3.4 .4 6.7 .9 10 1.3c64.1 7.1 133.6-15.1 153.2-80.7C566.9 194 576 75 576 58.4s-3.3-44.7-21.6-52.9c-15.8-7.1-40-14.9-103.2 29.8C385.1 81.9 314.1 176.4 288 227.1z"
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