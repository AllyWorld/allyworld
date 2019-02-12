package com.app.allyworld.AllyWebSite.enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginCredentials {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileId;
	private String userName;
	private String password;
	public LoginCredentials() {
		super();
		
	}
	public LoginCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public LoginCredentials(int profileId, String userName, String password) {
		super();
		this.profileId = profileId;
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public int getProfileId() {
		return profileId;
	}
	
	

}
