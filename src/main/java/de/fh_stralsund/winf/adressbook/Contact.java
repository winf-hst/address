package de.fh_stralsund.winf.adressbook;

import java.io.Serializable;

public class Contact implements Serializable {

	private static final long serialVersionUID = 4828762573623664811L;

	private String firstName;
	private String lastName;
	private String onlyAddress;
	private String fullAddress;
	
	public Contact(String fullAddress){
		this.fullAddress = fullAddress;
	}
	
	public Contact(String firstname, String lastName){
		this.firstName = firstname;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOnlyAddress() {
		return onlyAddress;
	}

	public void setOnlyAddress(String onlyAddress) {
		this.onlyAddress = onlyAddress;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	

}
