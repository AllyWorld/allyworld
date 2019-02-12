package com.allyworld.app.friendservice.entity;

import java.time.LocalDateTime;
import java.util.List;


public class Profile {
	private int profileId;
	private String userName;
	private String fullName;
	private String gender;
	private LocalDateTime dateOfBirth;
	private Long phoneNumber;
	private String relationShipStatus;
	private String currentAddress;
	private String permanentAddress;
	private List<Integer> friendsList;
	private List<Integer> pendingFriendList;
	private static int profileIdGenerator;
	static {
		profileIdGenerator = 100;
	}
	{
		profileId = profileIdGenerator++;
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profile(int profileId, String userName, String fullName, String gender, LocalDateTime dateOfBirth,
			Long phoneNumber, String relationShipStatus, String currentAddress, String permanentAddress,
			List<Integer> friendsList, List<Integer> pendingFriendList) {
		super();
		this.profileId = profileId;
		this.userName = userName;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.relationShipStatus = relationShipStatus;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.friendsList = friendsList;
		this.pendingFriendList = pendingFriendList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRelationShipStatus() {
		return relationShipStatus;
	}

	public void setRelationShipStatus(String relationShipStatus) {
		this.relationShipStatus = relationShipStatus;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public List<Integer> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<Integer> friendsList) {
		this.friendsList = friendsList;
	}

	public List<Integer> getPendingFriendList() {
		return pendingFriendList;
	}

	public void setPendingFriendList(List<Integer> pendingFriendList) {
		this.pendingFriendList = pendingFriendList;
	}
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", userName=" + userName + ", fullName=" + fullName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", relationShipStatus="
				+ relationShipStatus + ", currentAddress=" + currentAddress + ", permanentAddress=" + permanentAddress
				+ ", friendsList=" + friendsList + ", pendingFriendList=" + pendingFriendList + "]";
	}

}
