package com.studio124.zurvivor.bdd.modele;

public class User {
	
	
	int user_id;
	String user_login, user_password,user_password_check,user_country, user_lastname, user_firstname, user_address, user_birthday, user_mail;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_login() {
		return user_login;
	}
	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_password_check() {
		return user_password_check;
	}
	public void setUser_password_check(String user_password_check) {
		this.user_password_check = user_password_check;
	}
	public String getUser_country() {
		return user_country;
	}
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_login=" + user_login
				+ ", user_country=" + user_country + ", user_lastname="
				+ user_lastname + ", user_firstname=" + user_firstname
				+ ", user_address=" + user_address + ", user_birthday="
				+ user_birthday + ", user_mail=" + user_mail + "]";
	}

	
	

	

}
