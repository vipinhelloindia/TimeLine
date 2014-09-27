package com.timeline.app.utils;

import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TypefaceCache {
	public static final int											MEDUIM	= 0;
	public static final int											REGULAR	= 1;

	private static final Hashtable<String, SoftReference<Typeface>>	mTypefaceCache;

	static {
		mTypefaceCache = new Hashtable<String, SoftReference<Typeface>>();
	}

	protected static Typeface getTypeface(Context context) {
		return getTypeface(context, Typeface.NORMAL);
	}

	public static Typeface getTypeface(Context context, int typefacetype) {
		if (context == null)
			return null;
		String typefaceName = "";
		switch (typefacetype) {
		case MEDUIM:
			typefaceName = "DINOffc-Medi.ttf";
			break;
		case REGULAR:
			typefaceName = "DINOffc.ttf";
			break;

		}

		synchronized (mTypefaceCache) {

			if (mTypefaceCache.get(typefaceName) != null) {
				SoftReference<Typeface> ref = mTypefaceCache.get(typefaceName);
				if (ref.get() != null) {
					return ref.get();
				}
			}

			Typeface typeface = Typeface.createFromAsset(context.getAssets(), typefaceName);
			mTypefaceCache.put(typefaceName, new SoftReference<Typeface>(typeface));
			return typeface;

		}

	}

	/*
	 * sets the typeface for a TextView (or TextView descendant such as EditText
	 * or Button) based on the passed attributes, defaults to normal typeface
	 */
	protected static void setCustomTypeface(Context context, TextView view, int typefacetype) {
		if (context == null || view == null)
			return;

		// skip at design-time
		if (view.isInEditMode())
			return;

		Typeface typeface = getTypeface(context, typefacetype);
		if (typeface != null) {
			view.setTypeface(typeface);
		}
	}

	/**
	 * @param pContext
	 * @param pFontFileNameInAssets
	 * @return true if font is applied, false otherwise
	 */
	public static boolean changeDeviceTypeface(Context pContext, String pStaticFieldName, int typefacetype) {
		try {
			Field StaticField = Typeface.class.getDeclaredField(pStaticFieldName);
			StaticField.setAccessible(true);
			Typeface newTypeface = getTypeface(pContext, typefacetype);
			StaticField.set(null, newTypeface);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param pView
	 * @param pContext
	 * @param pFontFileNameInAssets
	 * @return
	 */
	public static boolean setCustomFont(View pView, Context pContext, int typefacetype) {

		try {
			Typeface tf = getTypeface(pContext, typefacetype);
			if (pView instanceof TextView) {
				((TextView) pView).setTypeface(tf);
			} else {
				((Button) pView).setTypeface(tf);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}