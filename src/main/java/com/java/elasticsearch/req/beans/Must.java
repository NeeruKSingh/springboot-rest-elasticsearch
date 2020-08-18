
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Must {

	@JsonProperty("term")
    private final Term term;
	
	@JsonProperty("terms")
	private final Terms terms;
	
	@JsonProperty("match")
	private final Match match;
	

	
	@JsonProperty("query_string")
	private final QueryString queryString;
	
    
    @SuppressWarnings("unused")
	private Must() {
    	this(null, null,null,null);
    }
    
    public Must(final Term term, final Match match,final Terms terms,QueryString queryString) {
		
		this.term = term;
		this.match = match;
		this.terms=terms;
	
		this.queryString=queryString;
		
	}

	public static Must createMustWithMatch(final Match match) {
    	return new Must(null, match,null,null);
    }
	
	public static Must createMustWithTerm(final Term term) {
    	return new Must(term, null,null,null);
    }
	
	public static Must createMustWithTerms(final Terms terms) {
    	return new Must(null, null,terms,null);
    }
	
	
	
	
	public static Must createMustWithQueryString(final QueryString qs) {
    	return new Must(null, null,null,null);
    }
	
	public Terms getTerms() {
		return terms;
	}

	public Match getMatch() {
		return match;
	}

    public Term getTerm() {
        return term;
    }

	@Override
	public String toString() {
		return "Must [term=" + term + ", match=" + match + "]";
	}

    /*@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }*/
    
}