package com.xyz.socialmedia.dto;

public class LoginDTO {
public String email;
public String password;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "LoginDTO [email=" + email + ", password=" + password + "]";
}



}
