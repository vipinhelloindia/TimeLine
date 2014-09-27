
package com.timeline.app.model.stream;


public class Cover_image{
   	private int height;
   	private boolean is_default;
   	private String url;
   	private int width;

 	public int getHeight(){
		return this.height;
	}
	public void setHeight(int height){
		this.height = height;
	}
 	public boolean getIs_default(){
		return this.is_default;
	}
	public void setIs_default(boolean is_default){
		this.is_default = is_default;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public int getWidth(){
		return this.width;
	}
	public void setWidth(int width){
		this.width = width;
	}
}
