package com.timeline.app.model.stream;

import java.util.Date;

public class Data {
	private String canonical_url;
	private Date created_at;
	private String html;
	private String id;
	private boolean machine_only;
	private int num_replies;
	private int num_reposts;
	private int num_stars;
	private String pagination_id;

	private String text;
	private String thread_id;

	private Source source;
	private Entities entities;
	private User user;

	public String getCanonical_url() {
		return this.canonical_url;
	}

	public void setCanonical_url(String canonical_url) {
		this.canonical_url = canonical_url;
	}

	public Date getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getMachine_only() {
		return this.machine_only;
	}

	public void setMachine_only(boolean machine_only) {
		this.machine_only = machine_only;
	}

	public int getNum_replies() {
		return this.num_replies;
	}

	public void setNum_replies(int num_replies) {
		this.num_replies = num_replies;
	}

	public int getNum_reposts() {
		return this.num_reposts;
	}

	public void setNum_reposts(int num_reposts) {
		this.num_reposts = num_reposts;
	}

	public int getNum_stars() {
		return this.num_stars;
	}

	public void setNum_stars(int num_stars) {
		this.num_stars = num_stars;
	}

	public String getPagination_id() {
		return this.pagination_id;
	}

	public void setPagination_id(String pagination_id) {
		this.pagination_id = pagination_id;
	}

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getThread_id() {
		return this.thread_id;
	}

	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
