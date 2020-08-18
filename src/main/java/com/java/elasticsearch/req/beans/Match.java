package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class Match {

	
	
	@JsonProperty("user_id")
	private final Long userId;
	
	@JsonProperty("blocked_users")
	private final Long blockedId;
	
	@JsonProperty("expertises")
	private final String expertise;
	
	@JsonProperty("ratedByUserId")
	 private final Long ratedByUserId;
	 
	 
	@JsonProperty("status")
	private final Integer status;
	
	@JsonProperty("name")
	private final String name;
	
	private Match(){
		this(null,null,null,null,null,null);
	}

	public Match( Long userId,Long blockedId,String expertise,Integer status,Long ratedByUserId ,String name) {
		super();
		
		this.userId = userId;
		this.blockedId=blockedId;
		this.expertise=expertise;
		this.status=status;
		this.ratedByUserId=ratedByUserId;
		this.name= name;
		
	}

   public static Match withUserId(final Long userId) {
		return new Match( userId,null,null,null,null,null);
	}
	
   public static Match withBlockedId(final Long blockedId) {
		return new Match( null,blockedId,null,null,null,null);
	}

   
	public static Match withExpertise(final String expertise) {
 		return new Match( null,null,expertise,null,null,null);
 	}
	
	public static Match withStatus(final Integer status) {
 		return new Match( null,null,null,status,null,null);
 	}
	
	public static Match withRatedUserId(final long ratedId) {
 		return new Match( null,null,null,null,ratedId,null);
 	}
	
	public static Match withName(final String name) {
 		return new Match( null,null,null,null,null,name);
 	}
	public Long getBlockedId() {
	return blockedId;
         }

     public String getExpertise() {
	 return expertise;
         }

	@Override
	public String toString() {
		return "Match [ userId=" + userId + "]";
	}



	public Long getUserId() {
		return userId;
	}
	
}
