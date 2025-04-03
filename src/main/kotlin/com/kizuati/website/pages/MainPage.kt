package com.kizuati.website.pages

import com.kizuati.website.Page
import com.kizuati.website.StyleSheet
import com.kizuati.website.components.*
import com.kizuati.website.util.px
import kotlinx.html.*

object MainPage : Page() {
    override val title = "Kizu's Properly Precious Portfolio"
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
                }
                div {
                    id = "bio"
                    article {
                        h1 { +"Hi,I'm Kizu." }
                        h2 { +"I'm a semi-professional video maker." i {+"That's to say, I edit and write things."} }
                        +"I've done a lot of things, including standardizing full blown video essays that get made within hours of new content dropping..."
			br2
                        +"...All the way to scrubbing through 24h of VOD footage to construct a highlights reel while sick to the core."
                        br2
                        +"Safe to say, I've got the skills and I don't value my own sanity." ;
                        +"Want to have fun working with your video editor? "; b { +" Reach out now :)" }
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
                        "UoieCUMMVFQ": "Very in depth rapidly made video essay meets news piece content that covers DBD's PTBs."
                    },
                    "Podcast/Misc": { 
                        "SXJsp8gh9fk": "Simple-ish edit of a D&D session adding music and backgrounds,cutting around dead air.",
						"6Fi4Buy86Ow": "Simpler-ish edit of a D&D session adding music and backgrounds,cutting around dead air."
                    },
                    "Montage": { 
						"DNnV2Lh8vRM": "Highlights reel of weird and chaotic happenstances with memes and jokes thrown in."
                    },
					"Highlights": { 
                        "VhLVh5mauu4": "Long-form highlights from around 24 hours of VODs put together into a punchy package.",
                    },
                    "Game Essay": {
                        "x8llwkwq6t4": "My foray into general game centric video essays. Still a WIP."
                    }
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
                p {
                    style = "text-align:center;"
                    +"These videos are a random selection with short descriptions of work I've done in the past." 
		    br
	            +"Over time I'm evolving to bigger and bigger projects. "
                }
                p {
                    style = "text-align:center;"
                    +"Keep in mind, if your style isn't here, it's perfectly valid to reach out anyhoo. I'll tell if I'm a good pick for your idea."
                }
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
                    align-self: flex-start;
                
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
            
            .combo {
                width: 75%;
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
            
            .combo {
                width: 90%;
            }
            
            #profile_picture {
                align-self: center;
            }
            
            .contact {
                padding-top: 30px;
            }
            
            .video-stack {
              width: 90%;
            }
        """.trimIndent()
    }
}
