package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.*
import kotlinx.html.*

object SocialPage : Page() {
    override val path = "social"

    override fun HEAD.head() {
        script("module", "/scripts/bsky-embed.js") {}
        script("module", "/scripts/yt-embed.js") {}
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
                        a(href = "https://s.kizuati.com/bsky", target = "_blank") {
                            style="text-decoration:none; color: inherit"
                            p {
                                id = "bsky-displayname"
                                style = "margin-top: 4px; margin-bottom: 0px"
                            }
                        }
                        a(href = "https://s.kizuati.com/bsky", target = "_blank") {
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
            stack(Justify.LEFT, "widget") {
                id = "youtube-variety"
                img(src = "images/yt_variety_banner.webp") {
                    id = "yt-variety-banner"
                    width = "350"
                    style = "border-top-left-radius: 5px; border-top-right-radius: 5px;"
                }
                split(Justify.LEFT) {
                    div {
                        style = "width: 100px; height: 40px"
                        img(src = "images/yt_variety_pfp.webp") {
                            id = "yt-dbd-pfp"
                            width = "70"
                            height = "70"
                            style =
                                "border: 1.5px solid #161e27; border-radius: 50%; position: relative; left: 10px; bottom: 35px;"
                        }
                    }
                    stack(Justify.LEFT) {
                        a(href = "https://s.kizuati.com/youtubevariety", target = "_blank") {
                            style="text-decoration:none; color: inherit"
                            p {
                                id = "yt-variety-displayname"
                                style = "margin-top: 4px; margin-bottom: 0px"
                                +"Kizu"
                            }
                        }
                    }
                }
                p {
                    id = "yt-variety-desc"
                    style = "margin-left: 15px; margin-top: 5px; font-size: 15px;"
                    +"Hi I'm Kizu! I'm chaos incarnate with a strong hit of queerness that plays, streams and edits videogame sillies."
                }
                div {
                    id = "yt-variety-posts"
                    style = "overflow-y: auto; height: auto;"
                }
            }
            stack(Justify.LEFT, "widget") {
                id = "youtube-dbd"
                img(src = "images/yt_dbd_banner.webp") {
                    id = "yt-dbd-banner"
                    width = "350"
                    style = "border-top-left-radius: 5px; border-top-right-radius: 5px;"
                }
                split(Justify.LEFT) {
                    div {
                        style = "width: 100px; height: 40px"
                        img(src = "images/yt_dbd_pfp.webp") {
                            id = "yt-dbd-pfp"
                            width = "70"
                            height = "70"
                            style =
                                "border: 1.5px solid #161e27; border-radius: 50%; position: relative; left: 10px; bottom: 35px;"
                        }
                    }
                    stack(Justify.LEFT) {
                        a(href = "https://s.kizuati.com/youtubedbd", target = "_blank") {
                            style="text-decoration:none; color: inherit"
                            p {
                                id = "yt-dbd-displayname"
                                style = "margin-top: 4px; margin-bottom: 0px"
                                +"MaybeKizu"
                            }
                        }
                    }
                }
                p {
                    id = "yt-dbd-desc"
                    style = "margin-left: 15px; margin-top: 5px; font-size: 15px;"
                    +"Hi I'm Kizu! I like to talk about game design."
                }
                div {
                    id = "yt-dbd-posts"
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