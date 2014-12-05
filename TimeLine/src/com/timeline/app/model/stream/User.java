package com.timeline.app.model.stream;

public class User {
	private Avatar_image avatar_image;
	private String canonical_url;
	private Counts counts;
	private Cover_image cover_image;
	private String created_at;
	private Description description;
	private String id;
	private String locale;
	private String name;
	private String timezone;
	private String type;
	private String username;

	public Avatar_image getAvatar_image() {
		return this.avatar_image;
	}

	public void setAvatar_image(Avatar_image avatar_image) {
		this.avatar_image = avatar_image;
	}

	public String getCanonical_url() {
		return this.canonical_url;
	}

	public void setCanonical_url(String canonical_url) {
		this.canonical_url = canonical_url;
	}

	public Counts getCounts() {
		return this.counts;
	}

	public void setCounts(Counts counts) {
		this.counts = counts;
	}

	public Cover_image getCover_image() {
		return this.cover_image;
	}

	public void setCover_image(Cover_image cover_image) {
		this.cover_image = cover_image;
	}

	public String getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Description getDescription() {
		return this.description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
