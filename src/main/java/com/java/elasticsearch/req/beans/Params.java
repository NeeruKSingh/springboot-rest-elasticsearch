package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Params {
	
	

	
	@JsonProperty("name")
	private final String name;
	
	@JsonProperty("basic_info")
	private final String userInfo;
	
	@SuppressWarnings("unused")
	private Params(){
		this(null,null);
	}
	
	
	public Params(String name,String userInfo){
	
		this.name=name;
		this.userInfo=userInfo;
		
		
	}

	
	
	
	
	
	
	public static Params withName(String name){
		return new Params(name,null);
	}
	public static Params withBasicInfo(String info){
		return new Params(null,info);
	}
	

	public String getName() {
		return name;
	}


	public String getUserInfo() {
		return userInfo;
	}


	
	
}