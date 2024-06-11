package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.Justify
import com.kizuati.website.components.br2
import com.kizuati.website.components.email
import com.kizuati.website.components.split
import com.kizuati.website.util.px
import kotlinx.html.*

object MainPage : Page() {
    override val title = "Kizu's Landing Page"
    override val path = "index"

    override fun additionalStyleSheets(): List<StyleSheet> {
        return listOf(Style)
    }

    override fun BODY.body() {
        split(
            Justify.CENTER,
            { img("Kizu's profile picture", "images/pfp.png") {
                id = "profile_picture"
                width = 400.px
                height = 400.px
            }},
            {
                id = "bio"
                article {
                    h1 { +"Hi,I'm Kizu" }
                    h2 { +"I edit videos and like to waffle about game design." }
                    +"Those videos range from game design deep dives to stream highlights with anything in between."
                    br2
                    +"If you want your videos edited - hit me up,we'll work something out :)"
                }
            },
            "heading"
        )
        
        val youtubeVideoIDs = mapOf(
            // Best of Helios || Returning To Billy
            "VhLVh5mauu4" to "These are some of the stream highlights I've done recently. Pacing,SFX,Music,etc. - all at the client's discretion.",
            // Dungeons & Dragons PTB Review
            "Ivon9mr6XNE" to "There's also a lot of game design focused deep dive videos made by me on DBD that have pretty graphics to accompany my points."
        )

        div("grid") {
            youtubeVideoIDs.forEach { id, desc ->
                div("grid-item") {
                    div("stack") {
                        iframe {
                            width = "480"
                            height = "270"
                            title = "YouTube video player"
                            src = "https://www.youtube-nocookie.com/embed/${id}"
                            attributes["frameborder"] = "0"
                            attributes["allow"] = "clipboard-write; encrypted-media; picture-in-picture; web-share"
                            attributes["allowfullscreen"] = "1"
                            attributes["class"] = "embed"
                        }
                        div("video-desc") {
                            +desc
						
                        }
                    }
                }
            }
        }

        split(
            Justify.CENTER,
            {id = "footer-name"; +"Kizu"; br; +"Axiosov" },
            {id = "footer-email"
                +"Contact me?"
                br2
                email("sponsor@kizuati.com")
            },
            "footer"
        )
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
                
                .split.footer {
                    margin-top: 60px;
                    margin-bottom: 20px;
                }
                
                .grid {
                    margin-top: 20px;
                    margin-bottom: 20px;
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
                
                .stack {
                    display: grid;
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
            """.trimIndent()
        }

        override fun getSmall() = """
            #profile_picture {
                width: 200px;
            }
            
            #bio {
                width: 70%;
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
