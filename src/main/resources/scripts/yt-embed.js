// DBD : UClsLhSdrvw40BmeSjTzflLg
// Variety : UCRc1heLm9DlpqpdKdNO0aow

var LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard = false;

addEventListener("DOMContentLoaded", (event) => {
	LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard = true;
});

async function constructYtEmbed(prefix, channelId) {
	console.log(prefix)
	console.log(channelId)

	let searchReq = await fetch("https://social-embed.kizuati.com/" + channelId);
	let searchRaw = await searchReq.json();
	let videoIDs = searchRaw.items.map(it => it.id.videoId)

	console.log(videoIDs)

	const videoList = document.getElementById(prefix + "-posts")

	for (let video of videoIDs) {
		const videoContainer = document.createElement("div");
		const iframe = document.createElement("iframe");

		videoContainer.className = "video-container";

		iframe.className = "embed";
		iframe.width = "350";
		iframe.height = "210";
		iframe.title = "YouTube video player";
		iframe.src = "https://www.youtube-nocookie.com/embed/" + video;
		iframe.setAttribute("frameborder", "0");
		iframe.setAttribute("allow", "clipboard-write; encrypted-media; picture-in-picture; web-share");
		iframe.setAttribute("allowfullscreen", "1");
		iframe.setAttribute("class", "embed");

		videoContainer.appendChild(iframe)
		videoList.appendChild(videoContainer)
	}
}

if (LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard) {
	constructYtEmbed("yt-dbd", "UClsLhSdrvw40BmeSjTzflLg")
	constructYtEmbed("yt-variety", "UCRc1heLm9DlpqpdKdNO0aow")
} else {
	addEventListener("DOMContentLoaded", (event) => {
    	constructYtEmbed("yt-dbd", "UClsLhSdrvw40BmeSjTzflLg")
		constructYtEmbed("yt-variety", "UCRc1heLm9DlpqpdKdNO0aow")
    });
}