package com.timeline.app.ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.timeline.app.utils.TypefaceCache;

public class RegularTextView extends TextView {

	public RegularTextView(Context context) {
		super(context);
		setCustomFont(context);
	}

	public RegularTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setCustomFont(context);
	}

	public RegularTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setCustomFont(context);
	}

	public boolean setCustomFont(Context ctx) {
		Typeface tf = null;
		try {
			tf = TypefaceCache.getTypeface(ctx, TypefaceCache.REGULAR);
		} catch (Exception e) {
			return false;
		}

		setTypeface(tf);
		return true;
	}

}