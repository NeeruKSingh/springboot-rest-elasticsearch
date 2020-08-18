
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Source {

	@JsonProperty("user_id")
	private  String userId;

	@JsonProperty("user_name")
	private String name;

	@JsonProperty("email_id")
	private  String emailId;

	@JsonProperty("basic_info")
	private String basicInfo;

	public Source() {
	}

	public Source(final String userId, final String name, final String emailId, final String basicInfo) {

		
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.basicInfo = basicInfo;

	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getBasicInfo() {
		return basicInfo;
	}

	public static Source getSource(User user) {
		Source source = new Source(user.getId(), user.getName(), user.getEmailId(), user.getBasicInfo());

		return source;
	}

}
