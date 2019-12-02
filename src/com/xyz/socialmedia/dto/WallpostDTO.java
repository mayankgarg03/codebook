package com.xyz.socialmedia.dto;

public class WallpostDTO {

	public int id;
	public String email;
	public String postMessage;
	public String dateofpost;
	public String friendstagged;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostMessage() {
		return postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	public String getDateofpost() {
		return dateofpost;
	}
	public void setDateofpost(String dateofpost) {
		this.dateofpost = dateofpost;
	}
	public String getFriendstagged() {
		return friendstagged;
	}
	public void setFriendstagged(String friendstagged) {
		this.friendstagged = friendstagged;
	}
	@Override
	public String toString() {
		return "WallpostDTO [id=" + id + ", email=" + email + ", postMessage=" + postMessage + ", dateofpost="
				+ dateofpost + ", friendstagged=" + friendstagged + "]";
	}
	
	
	
	
}
