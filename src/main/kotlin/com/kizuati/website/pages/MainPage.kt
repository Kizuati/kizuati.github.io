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
        split(Justify.SPACE_EVENLY, "heading") {
            split(Justify.LEFT, "combo") {
                img("Kizu's profile picture", "images/pfp.png") {
                    id = "profile_picture"
                    width = 400.px
                    height = 400.px
                    style = "align-self: flex-start;"
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
            div("contact") {
                stack(Justify.SPACE_EVENLY) {
                    split(Justify.CENTER, "comm-links") {
                        div {
                            id = "comm-email"
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
        }

        split(Justify.SPACE_EVENLY) {
            id = "videos"
            script { unsafe { +"""
                let vC = document.getElementById("videos");
                let videos = {
                    "VhLVh5mauu4": "Quam at odio iusto omnis animi fugit. Tempore qui sapiente nulla animi. Et aperiam et eveniet repellat unde ea.",
                    "yyc-o4DJHic": "Quam at odio iusto omnis animi fugit. Tempore qui sapiente nulla animi. Et aperiam et eveniet repellat unde ea.",
                    "Ivon9mr6XNE": "Quam at odio iusto omnis animi fugit. Tempore qui sapiente nulla animi. Et aperiam et eveniet repellat unde ea.",
                    "lsEK0gzTCxc": "Quam at odio iusto omnis animi fugit. Tempore qui sapiente nulla animi. Et aperiam et eveniet repellat unde ea."
                }
                let put = [];
                var randomID = function (obj) {
                    var keys = Object.keys(obj);
                    return keys[ keys.length * Math.random() << 0];
                };
                let insertVideo = function(id, desc) {
                    const stack = document.createElement("div");
                    const descDiv = document.createElement("div");
                    const videoContainer = document.createElement("div");
                    const iframe = document.createElement("iframe");
                    
                    stack.className = "stack video-stack";
                    stack.style = "justify-content: center";
                    
                    videoContainer.className = "video-container";
                    
                    iframe.className = "embed";
                    iframe.width = "384";
                    iframe.height = "216";
                    iframe.title = "YouTube video player";
                    iframe.src = "https://www.youtube-nocookie.com/embed/" + id;
                    iframe.setAttribute("frameborder", "0");
                    iframe.setAttribute("allow", "clipboard-write; encrypted-media; picture-in-picture; web-share");
                    iframe.setAttribute("allowfullscreen", "1");
                    iframe.setAttribute("class", "embed");
                    
                    descDiv.className = "video-desc";
                    descDiv.append(desc);
                    
                    videoContainer.appendChild(iframe)
                    stack.appendChild(videoContainer);
                    vC.appendChild(stack);
                    stack.appendChild(descDiv);
                };
                let insertRandom = function() {
                    var rK = randomID(videos);
                    while (put.includes(rK)) { rK = randomID(videos); };
                    console.log(rK);
                    put.push(rK);
                    insertVideo(rK, videos[rK])
                }
                insertRandom();
                insertRandom();
                insertRandom();
                insertRandom();
            """.trimIndent() }}
        }

        article("content") {
            +" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pharetra, erat ut accumsan aliquet, eros elit viverra leo, in scelerisque mauris quam tristique diam. Etiam sollicitudin dolor sed ex feugiat pharetra. Quisque id ligula ut erat iaculis suscipit. Mauris vitae tincidunt eros. Curabitur maximus tincidunt elit, nec consectetur elit faucibus vel. Sed venenatis lacinia venenatis. Suspendisse volutpat gravida enim eu suscipit. Aliquam erat volutpat. Aliquam porttitor diam eget varius iaculis. Morbi ac ligula vel elit imperdiet mattis at eu justo. Praesent nec odio enim."
            br2
            +"Etiam ullamcorper felis nec sem dignissim, eleifend maximus tortor pellentesque. Morbi eros leo, ultricies et eleifend sed, mollis vitae libero. Sed vehicula mauris vel leo sagittis, vel tincidunt libero suscipit. Nulla dignissim odio lobortis velit maximus pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam sollicitudin pulvinar tincidunt. Morbi non vulputate urna. Nulla quis justo nulla. Mauris lobortis elementum sem, id vestibulum nisl placerat ac. "
        }
    }

    private fun DIV.video(id: String, desc: String) {
        stack(Justify.CENTER, "video-stack") {
            div("video-container") {
                iframe {
                    width = "384"
                    height = "216"
                    title = "YouTube video player"
                    src = "https://www.youtube-nocookie.com/embed/${id}"
                    attributes["frameborder"] = "0"
                    attributes["allow"] = "clipboard-write; encrypted-media; picture-in-picture; web-share"
                    attributes["allowfullscreen"] = "1"
                    attributes["class"] = "embed"
                }
            }

            div("video-desc") {
                +desc
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
                    font-size: 20px;
                    margin: 2em 2em 70px 2em;
                }
                
                .embed {
                    animation-duration: 2s;
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
                
                .comm-links {
                    padding-bottom: 2em;
                }
                
                .combo {
                    width: 60%;
                }
                
                #comm-email {
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
                    width: 100%;

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
                
                .video-stack {
                    width: 22%;
                }
                
                .video-desc {
                    width:100%;
                }
                
                .video-container {
                    position: relative;
                    width: 100%;
                    height: 0;
                    padding-bottom: 56.25%;
                }
                .embed {
                    position: absolute;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 100%;
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
