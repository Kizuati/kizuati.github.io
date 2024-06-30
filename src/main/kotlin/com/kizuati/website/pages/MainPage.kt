package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.*
import com.kizuati.website.util.px
import kotlinx.html.*

object MainPage : Page() {
    override val title = "Kizu's Landing Page"
    override val path = "index"

    override fun additionalStyleSheets(): List<StyleSheet> {
        return listOf(Style)
    }

    override fun BODY.body() {
        split(Justify.CENTER, "heading") {
            img("Kizu's profile picture", "images/pfp.png") {
                id = "profile_picture"
                width = 400.px
                height = 400.px
            }
            div {
                id = "bio"
                article {
                    h1 { +"Hi,I'm Kizu" }
                    h2 { +"I edit videos and like to waffle about game design." }
                    +"Those videos range from game design deep dives to stream highlights with anything in between."
                    br2
                    +"If you want your videos edited - hit me up,we'll work something out :)"
                }
            }
        }


        div("split content") {
            style = "justify-content: ${Justify.SPACE_EVENLY.css}"

            // Best of Helios || Returning To Billy
            // Best of Helios || July
            div {
                videos(
                    "VhLVh5mauu4",
                    "yyc-o4DJHic",
                    "These are some of the stream highlights I've done recently. Pacing,SFX,Music,etc. - all at the client's discretion."
                )
            }

            div("contact") {
                stack(Justify.SPACE_EVENLY) {
                    split(Justify.CENTER, "footer") {
                        div { id = "footer-name"; +"Kizu"; br; +"Axiosov" }
                        div {
                            id = "footer-email"
                            +"Want to commission me?"
                            br2
                            email("commissions@kizuati.com")
                        }
                    }
                    a("/info", classes = "nav") {
                        button { +"Commission Info" }
                    }
                    a("/social", classes = "nav") {
                        button { +"Socials" }
                    }
                }
            }

            // Dungeons & Dragons PTB Review
            // Tomb Raider PTB Review
            div { videos("Ivon9mr6XNE", "CDmNF_Mchvw", "There's also a lot of game design focused deep dive videos made by me on DBD that have pretty graphics to accompany my points.") }
        }
    }

    fun DIV.videos(idA: String, idB: String, desc: String) {
        stack(Justify.CENTER) {
            iframe {
                width = "480"
                height = "270"
                title = "YouTube video player"
                src = "https://www.youtube-nocookie.com/embed/${idA}"
                attributes["frameborder"] = "0"
                attributes["allow"] = "clipboard-write; encrypted-media; picture-in-picture; web-share"
                attributes["allowfullscreen"] = "1"
                attributes["class"] = "embed"
            }
            div("video-desc") {
                +desc
            }
            iframe {
                width = "480"
                height = "270"
                title = "YouTube video player"
                src = "https://www.youtube-nocookie.com/embed/${idB}"
                attributes["frameborder"] = "0"
                attributes["allow"] = "clipboard-write; encrypted-media; picture-in-picture; web-share"
                attributes["allowfullscreen"] = "1"
                attributes["class"] = "embed"
            }
        }
    }

    object Style : StyleSheet() {
        override val name = "main_page"

        override fun getMain(): String {
            return """
                body {
                    margin: 0px 0px 0px 0px;
                }
                
                h1 {
                    font-size: 60px;
                    margin-bottom: 0px;
                }
                
                .split.heading {
                    background-color: #19191e;
                    padding-bottom: 40px;
                }
                
                .contact {
                    align-content: center;
                    padding: 10px;
                }
                
                .split.footer {
                    margin-top: 60px;
                    margin-bottom: 20px;
                }
                
                .content {
                    margin-top: 20px;
                    margin-bottom: 85px;
                }
                
                .embed {
                    animation-duration: 3s;
                    animation-name: slidein;
                }

                @keyframes slidein {
                  from {
                    margin-left: 100%;
                    width: 300%;
                  }

                  to {
                    margin-left: 0%;
                    width: 100%;
                  }
                }
                
                .video-desc {
                    margin-top: 10px;
                    width: 480px;
                }
                
                #footer-name {
                    text-align: center;
                    font-size: 30px;
                    margin-right: 20px;
                }
                
                #footer-email {
                    text-align: center;
                    font-size: 20px;
                }
                
                #profile_picture {
                    margin: 10px 30px 10px 10px;

                    max-width: 100%;
                    height: auto;
                }
                
                #bio {
                    font-size: 22px;
                    line-height: 1.3;
                    width: 40%;

                    display: flex;
                    align-items: center;
                }
                
                button {
                    border: none;
                    border-radius: 10px;
                    padding: 5px;
                    text-align: center;
                    display: inline-block;
                    font-size: 16px;
                    margin: 6px 4px;
                    width: 12em;
                    background-color: #2f2f33;
                    color: #FFFFFF;
                }
                
                a.nav {
                    align-self: center;
                }
            """.trimIndent()
        }

        override fun getSmall() = """
            #profile_picture {
                width: 200px;
            }
            
            #bio {
                width: 70%;
            }
            
            .split.content {
                flex-direction: column;
            }
            
            .split.footer {
                margin-bottom: 40px;
            }
        """.trimIndent()

        override fun getMobile() = """
            .split.footer {
                margin-top: 20px;
            }
            
            #footer-name {
                margin-right: 0px;
                margin-bottom: 20px;
            }
        """.trimIndent()
    }
}
