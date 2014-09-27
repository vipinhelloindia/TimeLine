package com.timeline.app.application;

import volley.toolbox.VolleySingleton;
import android.app.Application;

public class TimeLineApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		VolleySingleton.getInstance(getApplicationContext());
	}
}