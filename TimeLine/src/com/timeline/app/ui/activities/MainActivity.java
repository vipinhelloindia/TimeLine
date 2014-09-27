package com.timeline.app.ui.activities;

import volley.extras.Request.Method;
import volley.extras.Response.ErrorListener;
import volley.extras.Response.Listener;
import volley.extras.VolleyError;
import volley.toolbox.ImageLoader;
import volley.toolbox.VolleySingleton;
import volley.xrequest.GsonRequest;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;

import com.timeline.app.R;
import com.timeline.app.model.stream.TimeLine;
import com.timeline.app.ui.adapter.CommonAdapter;
import com.timeline.app.utils.ConnectivityUtils;
import com.timeline.app.utils.Constants;

public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener,
		Listener<TimeLine>, ErrorListener, OnScrollListener {
	SwipeRefreshLayout		swipeLayout;
	ListView				streamPostListView;
	String					STREAM_REQUEST	= "stream";
	GsonRequest<TimeLine>	gsonRequest;
	ImageLoader				imageLoader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorSchemeResources(R.color.gplus_color_1, R.color.gplus_color_3, R.color.gplus_color_2,
				R.color.gplus_color_4);

		streamPostListView = (ListView) findViewById(R.id.lv_streampost);
		streamPostListView.setOnScrollListener(this);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_action_bar);
		getSupportActionBar().setTitle("TimeLine ");
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));
		
		getStreamRequest();

	}

	@Override
	public void onRefresh() {

		swipeLayout.setEnabled(false);
		getStreamRequest();

	}

	public void getStreamRequest() {
		if (ConnectivityUtils.isNetworkEnabled(MainActivity.this)) {
			imageLoader = VolleySingleton.getInstance(getApplicationContext()).getImageLoader();
			gsonRequest = new GsonRequest<TimeLine>(Method.GET, Constants.REQUEST_URL, TimeLine.class,
					MainActivity.this, MainActivity.this);
			VolleySingleton.getInstance(getBaseContext()).addToDataRequestQueue(gsonRequest, STREAM_REQUEST);
			swipeLayout.setRefreshing(true);
		} else {
			Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();
			swipeLayout.setRefreshing(false);
			swipeLayout.setEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		error.getMessage();

	}

	@Override
	public void onResponse(final TimeLine timeLine) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				swipeLayout.setRefreshing(false);
				CommonAdapter adapter = new CommonAdapter(MainActivity.this, R.layout.product_grid_item, imageLoader,
						timeLine.getData());
				streamPostListView.setAdapter(adapter);
				swipeLayout.setEnabled(true);
			}
		}, 100);
	}

	@Override
	public void onScroll(AbsListView arg0, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if (firstVisibleItem == 0)
			swipeLayout.setEnabled(true);
		else
			swipeLayout.setEnabled(false);

	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int scrollState) {
		if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
			// imageLoader.stopProcessingQueue();
		} else {
			// imageLoader.startProcessingQueue();
		}

	}

}
