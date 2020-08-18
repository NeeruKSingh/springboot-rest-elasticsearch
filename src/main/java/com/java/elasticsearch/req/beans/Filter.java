
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Filter {

	@JsonProperty("bool")
    private final Bool bool;
    
	@JsonProperty("terms")
	private final Terms terms;
    
	@JsonProperty("query")
    private final Query query;

	@SuppressWarnings("unused")
	private Filter() {
    	this(null, null,null);
    }

    public Filter(final Bool bool, final Query query,Terms terms) {
		super();
		this.bool = bool;
		
		this.query = query;
		this.terms=terms;
	}

	public static Filter withTerms(Terms terms){
		return new Filter(null,null,terms);
	}

    public Bool getBool() {
        return bool;
    }



	public Query getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "Filter [bool=" + bool 
				+ ", query=" + query + "]";
	}

}