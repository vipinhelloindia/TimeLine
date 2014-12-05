package com.timeline.app.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Date;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author vipin.sahu
 * 
 *         This Class is used for mapping json String to T Class or T Type ;
 *         This Class take care of handling the Object and Array problem in Json
 *         This Class also take care of handles the DateDeserializer
 *         (yyyy-MM-dd'T'HH:mm:ss'Z')
 * 
 * @param <T>
 * 
 */
public final class GsonUtil {

	private GsonUtil() {

	}

	/**
	 * @param jsonString
	 * @param clazz
	 * @return T class
	 * 
	 *         Use this method only when u need to take care of Object and Array
	 *         of same name ;
	 */
	public static <T> T mapFromJSONHanldeObject(String jsonString,
			Class<T> clazz) {
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(
				new GenericAdapterFactory()).create();
		return gson.fromJson(jsonString, clazz);
	}

	/**
	 * @param jsonString
	 * @param typeof
	 * @return T class
	 * 
	 *         Use this method only when u need to take care of Object and Array
	 *         of same name ;
	 */
	public static <T> T mapFromJSONHanldeObject(String jsonString, Type typeof) {
		Gson gson = new GsonBuilder().registerTypeAdapterFactory(
				new GenericAdapterFactory()).create();
		return gson.fromJson(jsonString, typeof);
	}

	/**
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T mapFromJSON(String jsonString, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, clazz);
	}

	/**
	 * @param jsonString
	 * @param typeof
	 * @return
	 */
	public static <T> T mapFromJSON(String jsonString, Type typeof) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, typeof);
	}

	/**
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T mapFromJSONHandleDate(String jsonString, Class<T> clazz) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		Gson gson = gsonBuilder.create();
		return gson.fromJson(jsonString, clazz);
	}

	/**
	 * @param jsonString
	 * @param typeof
	 * @return
	 */
	public static <T> T mapFromJSONHandleDate(String jsonString, Type typeof) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
		Gson gson = gsonBuilder.create();
		return gson.fromJson(jsonString, typeof);
	}

	public static void writeStringToFile(Context context, String name,
			String jsonString) {

		FileOutputStream fos = null;
		try {

			fos = context.openFileOutput(name, Context.MODE_PRIVATE);
			fos.write(jsonString.getBytes());
			fos.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static String readStringFromFile(Context context, String name) {
		FileInputStream in = null;
		StringBuilder sb = null;
		try {
			sb = new StringBuilder();
			in = context.openFileInput(name);
			InputStreamReader inputStreamReader = new InputStreamReader(in);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			if (in != null)
				in.close();
			return sb.toString();
		} catch (Exception e) {
			if (in != null)
				e.printStackTrace();
		}
		return null;
	}
}
