package com.example.dao;

public class PersonDao {

    private String fullName;
    private String lastName;

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

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
