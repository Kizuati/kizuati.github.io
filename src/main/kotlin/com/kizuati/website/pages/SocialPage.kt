package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.*
import kotlinx.html.*

object SocialPage : Page() {
    override val path = "social"

    override fun HEAD.head() {
        script("module", "/scripts/bsky-embed.js") {}
    }

    override fun BODY.postBody() {
        unsafe {
            +"""
                <template id="bskypostt">
                    <a href="tmp" target="_blank" style="text-decoration:none; color: inherit">
                        <div class="bsky-post-instance">
                            <p></p>
                        </div>
                    </a>
                </template>
            """.trimIndent()
        }
    }

    override fun BODY.body() {
        h1 {
            split(null) {
                backButton()
                verticalDivider()
                +"Socials"
            }
        }
        h3 { +"All of these are real,official socials by me. If it's not here it's probably a cake/lie." }
		h3 { +"If you're looking to commission me,I recommend you to email me instead." }
        split(Justify.SPACE_AROUND, "links") {
            ul {
                entry(
                    "DBD Channel",
                    "https://s.kizuati.com/youtubedbd",
                    "#FF0000",
                    "M549.7 124.1c-6.3-23.7-24.8-42.3-48.3-48.6C458.8 64 288 64 288 64S117.2 64 74.6 75.5c-23.5 6.3-42 24.9-48.3 48.6-11.4 42.9-11.4 132.3-11.4 132.3s0 89.4 11.4 132.3c6.3 23.7 24.8 41.5 48.3 47.8C117.2 448 288 448 288 448s170.8 0 213.4-11.5c23.5-6.3 42-24.2 48.3-47.8 11.4-42.9 11.4-132.3 11.4-132.3s0-89.4-11.4-132.3zm-317.5 213.5V175.2l142.7 81.2-142.7 81.2z"
                )
            }
            ul {
                entry(
                    "Variety Channel",
                    "https://s.kizuati.com/youtubevariety",
                    "#FF0000",
                    "M549.7 124.1c-6.3-23.7-24.8-42.3-48.3-48.6C458.8 64 288 64 288 64S117.2 64 74.6 75.5c-23.5 6.3-42 24.9-48.3 48.6-11.4 42.9-11.4 132.3-11.4 132.3s0 89.4 11.4 132.3c6.3 23.7 24.8 41.5 48.3 47.8C117.2 448 288 448 288 448s170.8 0 213.4-11.5c23.5-6.3 42-24.2 48.3-47.8 11.4-42.9 11.4-132.3 11.4-132.3s0-89.4-11.4-132.3zm-317.5 213.5V175.2l142.7 81.2-142.7 81.2z"
                )
            }
        }
        split(Justify.SPACE_EVENLY) {
            iframe {
                classes = setOf("widget")
                src = "https://discord.com/widget?id=902933396504850432&theme=dark"
                width = "350"
                height = "500"
                attributes["allowtransparency"] = "true"
                attributes["frameborder"] = "0"
            }
            stack(Justify.LEFT, "widget") {
                id = "bsky"
                img {
                    id = "bsky-banner"
                    width = "350"
                    style = "border-top-left-radius: 5px; border-top-right-radius: 5px;"
                }
                split(Justify.LEFT) {
                    div {
                        style = "width: 100px; height: 40px"
                        img {
                            id = "bsky-pfp"
                            width = "70"
                            height = "70"
                            style =
                                "border: 1.5px solid #161e27; border-radius: 50%; position: relative; left: 10px; bottom: 35px;"
                        }
                    }
                    stack(Justify.LEFT) {
                        a(href = "https://bsky.app/profile/kizuati.com", target = "_blank") {
                            style="text-decoration:none; color: inherit"
                            p {
                                id = "bsky-displayname"
                                style = "margin-top: 4px; margin-bottom: 0px"
                            }
                        }
                        a(href = "https://bsky.app/profile/kizuati.com", target = "_blank") {
                            style="text-decoration:none; color: inherit"
                            p {
                                id = "bsky-handle"
                                style = "margin-top: 4px; margin-bottom: 2px; color: #AEBBC9;"
                            }
                        }
                    }
                }
                p {
                    id = "bsky-desc"
                    style = "margin-left: 15px; margin-top: 5px; font-size: 15px;"
                }
                div {
                    id = "bsky-posts"
                    style = "overflow-y: auto; height: auto;"
                }
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
                    max-width: 20em;
                }
                
                .widget {
                    width: 350px;
                    height: 500px;
                    background: #161e27;
                    border-radius: 5px; 
                }
                
                .bsky-post-instance {
                    border-color: #383838;
                    border-style: solid;
                    border-width: 1px 0 1px 0;
                    padding-right: 5px;
                    padding-left: 11px;
                }
            """.trimIndent()
        }

        override fun getMobile(): String {
            return """
                .backbutton {
                    display: none;
                }
                
                .links {
                    max-width: 100%;
                }
                
                li {
                    padding-top: 12px;
                }
                
                .widget {
                    margin-bottom: 22px;
                }
            """.trimIndent()
        }
    }
}