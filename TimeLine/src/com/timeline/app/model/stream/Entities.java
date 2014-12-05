package com.timeline.app.model.stream;

import java.util.ArrayList;
import java.util.List;

public class Entities {
	private ArrayList<Hashtags> hashtags;
	private ArrayList<Links> links;
	private List<Mention> mentions;

	public ArrayList<Hashtags> getHashtags() {
		return hashtags;
	}

	public void setHashtags(ArrayList<Hashtags> hashtags) {
		this.hashtags = hashtags;
	}

	public ArrayList<Links> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Links> links) {
		this.links = links;
	}

	public List<Mention> getMentions() {
		return mentions;
	}

	public void setMentions(List<Mention> mentions) {
		this.mentions = mentions;
	}

}
