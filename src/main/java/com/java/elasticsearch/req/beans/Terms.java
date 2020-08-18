
package com.java.elasticsearch.req.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(Include.NON_NULL)
public class Terms {

    @JsonProperty("user_id")
    private List<Long> userId;

    @JsonProperty("expertise_ids")
    private final List<String> expertises;
    
    @JsonProperty("gender")
    private final List<Integer> gender;
    /**
     * No args constructor for use in serialization
     * 
     */
    @SuppressWarnings("unused")
	private Terms() {
    	this(null,null,null);
    }

    /**
     * 
     * @param userId
     */
    public Terms(List<Long> userId,final List<String>expertises,final List<Integer> gender) {
        this.userId = userId;
        this.expertises=expertises;
        this.gender=gender;
    }

   
public static Terms withExpertises(List<String>expertises){
	return new Terms(null,expertises,null);
}

	public List<String> getExpertises() {
		return expertises;
	}

	public List<Long> getUserId() {
		return userId;
	}

	
	public List<Integer> getGender() {
		return gender;
	}

	public static Terms withUserId(List<Long> userId) {
        
        return new Terms(userId,null,null);
    }

	public static Terms withFbInterests(List<String> fbInterests) {
        
        return new Terms(null,fbInterests,null);
    }

	public static Terms withGender(final List<Integer> gender){
		return new Terms(null, null, gender);
	}
	@Override
	public String toString() {
		return "Terms [userId=" + userId + "]";
	}


}