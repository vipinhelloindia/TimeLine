package com.timeline.app.model.stream;

public class Description {
	private Entities entities;
	private String html;
	private String text;

	public Entities getEntities() {
		return this.entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	public String getHtml() {
		return this.html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
