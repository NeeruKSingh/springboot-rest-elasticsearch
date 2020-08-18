package com.java.elasticsearch.req.beans;

public class User {

	private String id;
	private String name;
	private String emailId;
	private String basicInfo;
	private String message;

	public User() {

	}

	public User(String id, String name, String emailId, String basicInfo, String message) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.basicInfo = basicInfo;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static User getUser(Source source) {
		User user = new User(source.getUserId(), source.getName(), source.getEmailId(), source.getBasicInfo(), "");
		return user;
	}

}
