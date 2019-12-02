package com.xyz.socialmedia.dto;

public class CommentDTO {
	
	public int cid;
	public int postid;
	public String commentBy;
	public String commentMessage;
	public String dateOfComment;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getCommentBy() {
		return commentBy;
	}
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	public String getCommentMessage() {
		return commentMessage;
	}
	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}
	public String getDateOfComment() {
		return dateOfComment;
	}
	public void setDateOfComment(String dateOfComment) {
		this.dateOfComment = dateOfComment;
	}
	@Override
	public String toString() {
		return "CommentDTO [cid=" + cid + ", postid=" + postid + ", commentBy=" + commentBy + ", commentMessage="
				+ commentMessage + ", dateOfComment=" + dateOfComment + "]";
	}
	
	

}
