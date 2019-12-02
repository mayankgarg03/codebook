package com.xyz.socialmedia.dto;

public class LikeDTO {
	
	public String postId;
	public String likedBy;
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}
	@Override
	public String toString() {
		return "LikeDTO [postId=" + postId + ", likedBy=" + likedBy + "]";
	}
	
	

}
