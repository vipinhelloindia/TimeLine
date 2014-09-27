package volley.xrequest;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import volley.extras.AuthFailureError;
import volley.extras.NetworkResponse;
import volley.extras.Request;
import volley.extras.Response;
import volley.extras.Response.ErrorListener;
import volley.extras.Response.Listener;
import volley.toolbox.HttpHeaderParser;

import com.timeline.app.model.stream.Data;
import com.timeline.app.model.stream.TimeLine;
import com.timeline.app.utils.GsonUtil;

public class GsonRequest<T> extends Request<T> {
	private Class<T>	clazz;
	private Listener<T>	listener;
	private Type		typeof;

	public GsonRequest(int method, String url, Class<T> clazz, Listener<T> listener,
			ErrorListener errorListener) {
		super(method, url, errorListener);
		this.clazz = clazz;
		this.listener = listener;

	}

	public GsonRequest(int method, String url, Type typeof, Listener<T> listener,
			ErrorListener errorListener) {
		super(method, url, errorListener);
		this.typeof = typeof;
		this.listener = listener;
	}

	

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		T t=null;
		if (clazz != null)
			t = GsonUtil.mapFromJSONHandleDate(new String(response.data), clazz);
		if (typeof != null)
			t = GsonUtil.mapFromJSONHandleDate(new String(response.data), typeof);
		
		TimeLine line = (TimeLine)t;
		List<Data> list =line.getData();
		Collections.sort(list, new Comparator<Data>() {

			@Override
			public int compare(Data d1, Data d2) {
				  return d1.getCreated_at().compareTo(d2.getCreated_at());
			}
		});
		return Response.success(t, HttpHeaderParser.parseCacheHeaders(response));
	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return super.getHeaders();
	}
}