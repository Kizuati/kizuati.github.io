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
                    "Deep Dive": { 
                        "lsEK0gzTCxc": "Scripted,highly detailed deep dive into DBD's PTBs with sections presenting & reviewing new & and changed content.",
                        "CDmNF_Mchvw": "Scripted,highly detailed deep dive into DBD's PTBs with sections presenting & reviewing new & and changed content."
                    },
                    "Podcast/Misc": { "SXJsp8gh9fk": "Simpler-ish edit of a D&D session adding music and backgrounds,cutting around dead air." },
                    "Montage": { "tjbuAB4dHss": "Random spur of the moment quick & dirty edit with lots of sillies and memes thrown around." },
					"Highlights": { "VhLVh5mauu4": "Long-form stream highlights content from around 24 hours of VODs put together into a punchy package." }
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
                    put.push(rK);
                    var rV = randomID(videos[rK]);
                    insertVideo(rV, videos[rK][rV]);
                }
                insertRandom();
                insertRandom();
                insertRandom();
                insertRandom();
            """.trimIndent() }}
        }

        split(Justify.CENTER) {
            article("content") {
                +"These videos are a random selection with short descriptions of work I've done in the past. If any of it catches your fancy,the commissions info button is in the top right ;)"
                br2
                +"Keep in mind, just because your style isn't represented here it doesn't meant I won't/can't do it! Feel free to reach out and ask me if your project makes sense! "
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
                    width: 90%;
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
