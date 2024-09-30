package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.*
import com.kizuati.website.util.px
import kotlinx.html.*

object InfoPage : Page() {
    override val path = "info"

    override fun BODY.body() {
        h1 {
            split(null) {
                backButton()
                verticalDivider()
                +"Commission Info"
            }
        }

        split(Justify.CENTER) {
            img("Image of a hooked survivor edited to be red, with a white question mark over it", "images/AYOK.webp") {
                id = "icon"
                width = 400.px
                height = 400.px
            }
            div {
                id = "bio"
                article {
                    h1 { +"All You Oughta Know" }
                    h2 { +"You can find my pricing & all the other important comm deets here." }
                    +"I go for about 10\$ per hour of work on a video,so for example,me working for 6 hours on a video of yours will cost you a nice 60\$. "
                    br2
                    +"If you want something especially fancy,my per hour rate can go up to 12-14\$ and you will be notified of that depending on the material,etc."
                }
            }
        }

        split(Justify.CENTER, "content") {
            img("Image of a running survivor edited to be red, with white text saying \"yes, no, maybe\" over it.", "images/E2.webp") {
                id = "ynm"
                width = 200.px
                height = 200.px
            }

            split(Justify.SPACE_EVENLY) {
                stack(Justify.SPACE_EVENLY, "buffer") {
                    div {
                        h2 { +"Things I will do" }
                        +"Add music,sound effects,motion,cut up your 10 hour VOD into something watchable."
                        br
                        +"Add in a few jokes of my own responding or making fun of you if you want them in/that's your jam."
                    }
                    div {
                        h2 { +"Things I wont do" }
                        +"Complicated After Effects/3D things. Especially intricate edits like manually keying out objects."
                        br
                        +"Basically any VFX heavy work. I also don't really do thumnbnails."
                    }
                    div {
                        h2 { +"Things I Could Do If You Pay Me A Bunch" }
                        +"Really painstaking music sync up for a lot of your clips. Graphics to explain your points with relevant information."
                        br
                        +"Basic thumbnails like my own if you *really* need them. Extra pay required."
                    }
                }
                stack(Justify.SPACE_BETWEEN) {
                    div {
                        h2 { +"Payment Details" }
                        +"You pay a 20\$ deposit upfront. This is an anti-scam measure,sorry."
                    }
                    div {
                        h2 { +"Commission Process" }
                        +"I prefer locally recorded VODs/footage. If you're on Twitch/Youtube and don't have local recordings,provide me with Editor access to your channel on the respective platform."
                        br2
                        +"Outline your expectations and give examples of something you want from your commission upfront."
                        br
                        +"If you have a style of video you'd like to copy,link that directly!"
                        br2
                        +"I will provide you with rough drafts as I continously assemble the video that we'll go over together while in voice chat. This is the stage you can give feedback on the project."
                        br2
                        +"After a few drafts I'll give you a 480P version of your final video. Afterwards you'll provide full payment and I'll give you a link to the full video download at a high resolution/bitrate."
                    }
                }
            }
        }
    }

    override fun additionalStyleSheets(): List<StyleSheet> {
        return listOf(Style)
    }

    object Style : StyleSheet() {
        override val name = "info"

        override fun getMain(): String {
            return """
                .content {
                    padding: 5px 5px 80px 5px;
                }
                
                .buffer {
                    padding-right: 4em;
                }
                
                #bio {
                    display: flex;
                }
                
                article {
                    align-self: center;
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
            """.trimIndent()
        }
    }
}