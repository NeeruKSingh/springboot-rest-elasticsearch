
package com.java.elasticsearch.req.beans;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Term {

	

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
	
	
	@JsonProperty("skipped_mentors")
	 private final Long skippedMentors;
	
	@JsonProperty("request_sent_mentors")
	private final Long requestSentMentors;
	
	
	@SuppressWarnings("unused")
	private Term(){
		this(null,null,null,null,null,null,null);
	}

	public Term( Long userId,Long blockedId,String expertise,Integer status,Long ratedByUserId,Long skippedMentors,Long requestSentMentors ) {
		super();
		
		this.userId = userId;
		this.blockedId=blockedId;
		this.expertise=expertise;
		this.status=status;
		this.ratedByUserId=ratedByUserId;
		this.skippedMentors=skippedMentors;
		this.requestSentMentors=requestSentMentors;
		
	}

   public static Term withUserId(final Long userId) {
		return new Term( userId,null,null,null,null,null,null);
	}
	
   public static Term withBlockedId(final Long blockedId) {
		return new Term( null,blockedId,null,null,null,null,null);
	}

   
	public static Term withExpertise(final String expertise) {
 		return new Term( null,null,expertise,null,null,null,null);
 	}
	
	public static Term withStatus(final Integer status) {
 		return new Term( null,null,null,status,null,null,null);
 	}
	
	public static Term withRatedUserId(final long ratedId) {
 		return new Term( null,null,null,null,ratedId,null,null);
 	}
	
	public static Term withSkippedMentor(final Long mentor) {
 		return new Term( null,null,null,null,null,mentor,null);
 	}
	
	public static Term withrequestSentMentor(final Long mentor) {
 		return new Term( null,null,null,null,null,null,mentor);
 	}
	
	public Long getRequestSentMentors() {
		return requestSentMentors;
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