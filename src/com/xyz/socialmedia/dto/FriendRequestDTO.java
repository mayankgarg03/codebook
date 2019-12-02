package com.xyz.socialmedia.dto;

public class FriendRequestDTO {
public String sendersmail;
public String receiversmail;
public int fid;
public String status;





public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getSendersmail() {
	return sendersmail;
}
public void setSendersmail(String sendersmail) {
	this.sendersmail = sendersmail;
}
public String getReceiversmail() {
	return receiversmail;
}
public void setReceiversmail(String receiversmail) {
	this.receiversmail = receiversmail;
}
@Override
public String toString() {
	return "FriendRequestDTO [sendersmail=" + sendersmail + ", receiversmail=" + receiversmail + ", fid=" + fid
			+ ", status=" + status + "]";
}

}
