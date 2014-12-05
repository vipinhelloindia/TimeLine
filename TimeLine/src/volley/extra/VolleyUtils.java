package volley.extra;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;

public class VolleyUtils {
	private VolleyUtils() {
	};

	public static boolean hasFroyo() {
		/*
		 * Can use static final constants like FROYO, declared in later versions
		 * of the OS since they are inlined at compile time. This is guaranteed
		 * behavior.
		 */
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
	}

	public static boolean hasGingerbread() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
	}

	public static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}

	public static boolean hasHoneycombMR1() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
	}

	public static boolean hasJellyBean() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
	}

	public static boolean hasKitKat() {

		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
	}

	public static int getDeviceRequiredHeight(Context context) {
		float density = context.getResources().getDisplayMetrics().density;

		if (density == 1.0) {
			return 120;
		} else if (density == 1.5) {
			return (int) (110 * 1.5);
		} else if (density == 2.0) {
			return (int) (130 * 2);
		} else if (density == 3.0) {
			return (int) (130 * 3.0);
		}
		return 300;
	}

	public static int getDeviceRequiredWidth(Context context) {
		float density = context.getResources().getDisplayMetrics().density;
		if (density == 1.0) {
			return 120;
		} else if (density == 1.5) {
			return (int) (110 * 1.5);
		} else if (density == 2.0) {
			return (int) (120 * 2);
		} else if (density == 3.0) {
			return (int) (120 * 3);
		}
		return 220;
	}

	public static int dpToPx(int dp, Context context) {
		Resources r = context.getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dp, r.getDisplayMetrics());
		return px;
	}

	public static String getCurrentApplicationVersion(Context context) {
		String version = "";
		PackageInfo packageInfo = null;

		try {
			packageInfo = (context.getApplicationContext().getPackageManager()
					.getPackageInfo("com.buyt.app", 0));
			version = packageInfo.versionName;
		} catch (NameNotFoundException nameNotFoundException) {
		} catch (Exception exception) {
		}

		return version;
	}
}
