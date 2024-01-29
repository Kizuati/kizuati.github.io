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
                    h2 { +"Professionally unprofessional game designer and video editor." }
                    +"I make deviously peculiar videos on game design. Sometimes I edit them, sometimes I edit videos for other people. You won't find a match for the silliness I have within me."
                    br2
                    +"If you want your videos edited,I'm a good choice. No bias :)"
                }
            },
            "heading"
        )
        
        val youtubeVideoIDs = mapOf(
            // Best of Helios || July
            "yyc-o4DJHic" to "This is an example of some simple stream highlights I can do. Sound effects,music,pacing - all is at the discretion of the client and content provided.",
            // How BHVR Failed To Fix Their Most Hated Killer
            "64pIEmr8ev0" to "I also do more general,podcast-esque videos too,with a more streamlined editing process,but they are slowly growing in different visual features as I expand my template collection."
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