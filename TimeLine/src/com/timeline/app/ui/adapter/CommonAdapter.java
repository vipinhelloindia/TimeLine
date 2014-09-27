package com.timeline.app.ui.adapter;

import java.util.List;

import volley.toolbox.ImageLoader;
import volley.toolbox.NetworkImageView;
import android.content.Context;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.timeline.app.R;
import com.timeline.app.model.stream.Data;

public class CommonAdapter extends ArrayAdapter<Data> {
	Context		context;
	int			layout;
	List<Data>	list;
	ImageLoader	imageLoader;

	public CommonAdapter(Context context, int resource, ImageLoader imageLoader, List<Data> objects) {
		super(context, resource, objects);
		this.context = context;
		this.layout = resource;
		this.list = objects;
		this.imageLoader = imageLoader;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Data getItem(int position) {

		return list.get(position);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		try {
			ViewHolder holder = null;
			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(layout, null);
				holder = new ViewHolder();
				holder.userTextView = (TextView) convertView.findViewById(R.id.tv_username);
				holder.postTextView = (TextView) convertView.findViewById(R.id.tv_post_text);
				holder.avatarImageView = (NetworkImageView) convertView.findViewById(R.id.im_avatar);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			Data timeLineData = getItem(position);

			String url = timeLineData.getUser().getAvatar_image().getUrl();
			if (url != null && !TextUtils.isEmpty(url)) {
				holder.avatarImageView.setImageUrl(url, imageLoader);
			}

			holder.userTextView.setText(timeLineData.getUser().getUsername());
			holder.postTextView.setText(timeLineData.getText());
			Linkify.addLinks(holder.postTextView, Linkify.ALL);
			holder.userTextView.setFocusable(false);
			holder.postTextView.setFocusable(false);
			return convertView;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return convertView;
	}

	private static class ViewHolder {
		TextView			userTextView;
		TextView			postTextView;
		NetworkImageView	avatarImageView;
	}
}
