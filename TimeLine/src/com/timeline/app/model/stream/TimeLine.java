package com.timeline.app.model.stream;

import java.util.ArrayList;

public class TimeLine {
	private ArrayList<Data> data;
	private Meta meta;

	public ArrayList<Data> getData() {
		return this.data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}
