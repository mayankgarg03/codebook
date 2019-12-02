package com.xyz.socialmedia.dto;

public class SignupDTO {

	String firstname;
	String lastname;
	String email;
	String password;
	String confirmemail;
	String dobDay;
	String dobYear;
	String worksAt;
	String address;
	String studentAt;
	String dobMonth;
	String gender;
	String photoname;
	
	
	
	
	
	
	
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getWorksAt() {
		return worksAt;
	}
	public void setWorksAt(String worksAt) {
		this.worksAt = worksAt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStudentAt() {
		return studentAt;
	}
	public void setStudentAt(String studentAt) {
		this.studentAt = studentAt;
	}
	public String getDobYear() {
		return dobYear;
	}
	public void setDobYear(String dobYear) {
		this.dobYear = dobYear;
	}
	
	
	
	public String getDobDay() {
		return dobDay;
	}
	public void setDobDay(String dobDay) {
		this.dobDay = dobDay;
	}
	public String getDobMonth() {
		return dobMonth;
	}
	public void setDobMonth(String dobMonth) {
		this.dobMonth = dobMonth;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
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
	public String getConfirmemail() {
		return confirmemail;
	}
	public void setConfirmemail(String confirmemail) {
		this.confirmemail = confirmemail;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "SignupDTO [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", confirmemail=" + confirmemail + ", dobDay=" + dobDay + ", dobYear=" + dobYear
				+ ", dobMonth=" + dobMonth + ", gender=" + gender + "]";
	}
	
	
	
}
