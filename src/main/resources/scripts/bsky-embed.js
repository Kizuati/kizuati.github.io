var LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard = false;

addEventListener("DOMContentLoaded", (event) => {
	LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard = true;
});

const response = await fetch("https://public.api.bsky.app/xrpc/app.bsky.actor.getProfile?actor=kizuati.com");
const data = await response.json();

async function constructEmbed() {
	const base = document.getElementById("bsky");

	document.getElementById("bsky-banner").src = data.banner;
	document.getElementById("bsky-pfp").src = data.avatar;
	document.getElementById("bsky-displayname").textContent = data.displayName;
	document.getElementById("bsky-handle").textContent = "@" + data.handle;
	document.getElementById("bsky-desc").textContent = data.description;

	let postsReq = await fetch("https://public.api.bsky.app/xrpc/app.bsky.feed.getAuthorFeed?actor=kizuati.com");
	let postsRaw = await postsReq.json();
	let posts = postsRaw.feed
		.filter((it) => it.reply == undefined && it.reason == undefined)
		.slice(0, 10)
		.map((it) => it.post);

	const embedBody = document.querySelector("#bsky-posts");
  	const template = document.querySelector("#bskypostt");

	for (let p of posts) {
		const clone = template.content.cloneNode(true);
		let cW = clone.querySelectorAll("a");
		let cC = clone.querySelectorAll("p");

		let magic = p.uri.lastIndexOf("/");
		cW[0].href = "https://bsky.app/profile/kizuati.com/post/" + p.uri.substring(magic + 1);

		cC[0].innerHTML = p.record.text
			.replaceAll("\n", "<br/>") // linebreak -> html break
			.replaceAll(/(?<!@|\.)(?:https?:\/\/)?(\b[a-zA-Z0-9\\]+\.[a-zA-Z0-9\.\\/]+)\b/mg, "<a href=\"https://$1\">$1</a>") // links
			.replaceAll(/@([a-zA-Z0-9\.\\]+)/gm, "<a href=\"https://bsky.app/profile/$1\">@$1</a>"); // mentions

		if (p.embed !== undefined) {
			cC[0].innerHTML = cC[0].innerHTML + "<p style=\"color: gray\">[image 🗗\uFE0E]</p>"
		}

		embedBody.appendChild(clone);
	}
}

if (LoadedThePageBecauseApparentlyBuildingAUsableEventSystemIsTooHard) {
	constructEmbed()
} else {
	addEventListener("DOMContentLoaded", (event) => {
    	constructEmbed()
    });
}