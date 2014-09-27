
package com.timeline.app.model.stream;


public class Counts{
   	private int followers;
   	private int following;
   	private int posts;
   	private int stars;

 	public int getFollowers(){
		return this.followers;
	}
	public void setFollowers(int followers){
		this.followers = followers;
	}
 	public int getFollowing(){
		return this.following;
	}
	public void setFollowing(int following){
		this.following = following;
	}
 	public int getPosts(){
		return this.posts;
	}
	public void setPosts(int posts){
		this.posts = posts;
	}
 	public int getStars(){
		return this.stars;
	}
	public void setStars(int stars){
		this.stars = stars;
	}
}
