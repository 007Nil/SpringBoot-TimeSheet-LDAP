package com.example.dao;

public class PersonDao {

	private String fullName;
	private String lastName;
	private String userName;
	private String description;
	private String mobile;
	private String street;
	private String postOfficeBox;
	private String postalCode;
	private String postalAddress;
	private String Natinality;
	private String state;
	private String organigation;
	private String email;

	public PersonDao() {
		// TODO Auto-generated constructor stub
	}

	
	public PersonDao(String fullName, String lastName) {
		this.fullName = fullName;
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	public void setPostOfficeBox(String postOfficeBox) {
		this.postOfficeBox = postOfficeBox;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}


	public String getNatinality() {
		return Natinality;
	}

	public void setNatinality(String natinality) {
		Natinality = natinality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrganigation() {
		return organigation;
	}

	public void setOrganigation(String organigation) {
		this.organigation = organigation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonDao [fullName=" + fullName + ", lastName=" + lastName + ", userName=" + userName
				+ ", description=" + description + ", mobile=" + mobile + ", street=" + street + ", postOfficeBox="
				+ postOfficeBox + ", postalCode=" + postalCode + ", postalAddress=" + postalAddress + ", Natinality=" + Natinality + ", state=" + state + ", organigation=" + organigation
				+ ", email=" + email + "]";
	}
}
