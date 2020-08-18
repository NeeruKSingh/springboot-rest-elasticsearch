
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Query {


	@JsonProperty("filtered")
    private Filtered filtered;
	
	@JsonProperty("bool")
	private final Bool bool;
	
	
	
	@JsonProperty("prefix")
	private Prefix prefix;

	
    @SuppressWarnings("unused")
	private Query() {
    	this(null, null,null);
    }
    
    public Query(Filtered filtered, Bool bool,Prefix prefix) {
		this.filtered=filtered;
		this.bool = bool;
		this.prefix=prefix;
		
	}

	public static Query withBool(final Bool bool) {
       return new Query(null, bool, null);
    }
     
	
	
   
    public static Query withFiltered(final Filtered filtered) {
    	 return new Query(filtered, null, null);
    }
    
   
    
    public static Query withPrefix(final Prefix prefix) {
      	 return new Query(null, null,prefix);
      }
    
   
       @Override
	public String toString() {
		return "Query [  bool=" + bool +  "]";
	}

	public Bool getBool() {
		return bool;
	}

	

	public Filtered getFiltered() {
		return filtered;
	}
	

}