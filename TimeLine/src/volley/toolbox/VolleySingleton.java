package volley.toolbox;

import volley.extras.DefaultRetryPolicy;
import volley.extras.Request;
import volley.extras.RequestQueue;
import volley.extras.VolleyUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION_CODES;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * Volley objects and Volley Helper objects
 */
public class VolleySingleton {
	private static VolleySingleton	mInstance	= null;
	private RequestQueue			mImageRequestQueue;
	private ImageLoader				mImageLoader;
	int								cacheSize, maxMemory;
	private RequestQueue			mDataRequestQueue;
	private String					mDefaultRequestTag;

	private VolleySingleton(Context context) {

		/** Data Request Queue to Manage all POST and GET request operation */
		mDefaultRequestTag = context.getPackageName();
		mDataRequestQueue = Volley.newRequestQueue(context);

		/** Image Request Queue to Manage all image related request */
		mImageRequestQueue = Volley.newRequestQueue(context);

		/** Use 1/10 th of the available memory for this memory cache. */
		maxMemory = (int) (Runtime.getRuntime().maxMemory() / (1024 * 1024));
		cacheSize = maxMemory / 20;
		int tempCahce = Math.max(cacheSize, 10);
		Log.d("vipin", "Max memory =" + maxMemory + "Cache size " + cacheSize + " MB" + " tempCahce =" + tempCahce);

		final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(tempCahce) {
			@Override
			protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
				super.entryRemoved(evicted, key, oldValue, newValue);
				try {
					// Log.println(Log.ASSERT, "vipin", "entry removed" + key);

				} catch (Exception e) {
				}
			}

			@Override
			protected int sizeOf(String key, Bitmap value) {
				final int bitmapSize = getBitmapSize(value) / 1024;
				return bitmapSize == 0 ? 1 : bitmapSize;
			}
		};

		mImageLoader = new ImageLoader(this.mImageRequestQueue, new ImageLoader.ImageCache() {

			public void putBitmap(String url, Bitmap bitmap) {
				mCache.put(url, bitmap);
			}

			public Bitmap getBitmap(String url) {
				return mCache.get(url);
			}

		});

	}

	public static VolleySingleton getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new VolleySingleton(context);
		}
		return mInstance;
	}

	/**
	 * Adds the specified request to the global queue using the Default TAG.
	 * 
	 * @param pRequest
	 * @throws IllegalStatException
	 *             if initialize has not yet been called
	 */

	public <T> void addToDataRequestQueue(Request<T> pRequest) {
		if (mDataRequestQueue == null) {
			throw new IllegalStateException("Not initialized");
		}

		if (pRequest.getTag() == null) {
			pRequest.setTag(mDefaultRequestTag);
		}
		pRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 30,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		mDataRequestQueue.add(pRequest);
	}

	public <T> void addToDataRequestQueue(Request<T> pRequest, String requestTag) {
		if (mDataRequestQueue == null) {
			throw new IllegalStateException("Not initialized");
		}
		pRequest.setTag(requestTag);

		pRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 30,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
		mDataRequestQueue.add(pRequest);
	}

	public RequestQueue getRequestQueue() {
		return this.mImageRequestQueue;
	}

	public ImageLoader getImageLoader() {
		return this.mImageLoader;
	}

	/**
	 * From KitKat onward use getAllocationByteCount() as allocated bytes
	 * can potentially be larger than bitmap byte count.
	 */
	@TargetApi(VERSION_CODES.KITKAT)
	public static int getBitmapSize(Bitmap bitmap) {

		if (VolleyUtils.hasKitKat()) {
			return bitmap.getAllocationByteCount();
		}

		if (VolleyUtils.hasHoneycombMR1()) {
			return bitmap.getByteCount();
		}

		// Pre HC-MR1
		return bitmap.getRowBytes() * bitmap.getHeight();
	}
}