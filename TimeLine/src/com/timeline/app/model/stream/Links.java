
package com.timeline.app.model.stream;


public class Links{
   	private int len;
   	private int pos;
   	private String text;
   	private String url;

 	public int getLen(){
		return this.len;
	}
	public void setLen(int len){
		this.len = len;
	}
 	public int getPos(){
		return this.pos;
	}
	public void setPos(int pos){
		this.pos = pos;
	}
 	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
}
