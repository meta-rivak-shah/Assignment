package com.metaparking.model;

/**
 * pojos is used to friend list of user
 * @author Rivak
 *
 */
public class UserFriendList {
	private int id;
	private String full_name;
	private String Organisation;
	private String Contact_number;
	private String Email_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getOrganisation() {
		return Organisation;
	}

	public void setOrganisation(String organisation) {
		Organisation = organisation;
	}

	public String getContact_number() {
		return Contact_number;
	}

	public void setContact_number(String contact_number) {
		Contact_number = contact_number;
	}

	public String getEmail_id() {
		return Email_id;
	}

	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}

	public UserFriendList(int id, String full_name, String organisation,
			String contact_number, String email_id) {
		super();
		this.id = id;
		this.full_name = full_name;
		Organisation = organisation;
		Contact_number = contact_number;
		Email_id = email_id;
	}

}