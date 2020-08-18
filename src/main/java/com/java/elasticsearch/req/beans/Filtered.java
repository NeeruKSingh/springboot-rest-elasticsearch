
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Filtered {

	@JsonProperty("query")
    private final Query query;
   
	@JsonProperty("filter")
    private final Filter filter;
   
    @SuppressWarnings("unused")
	private Filtered() {
    	this(null, null);
    }

    public Filtered(final Query query, final Filter filter) {
		super();
		this.query = query;
		this.filter = filter;
	}

	public static Filtered withQuery(final Query  query) {
		return new Filtered(query, null);
    }
	public static Filtered withFilter(final Filter filter) {
		return new Filtered(null, filter);
    }
   
	public static Filtered withFilterAndQuery(final Filter filter,final Query query) {
		return new Filtered(query, filter);
    }
   
    public Query getQuery() {
		return query;
	}
    
	

	public Filter getFilter() {
		return filter;
	}

	@Override
	public String toString() {
		return "Filtered [query=" + query + ", filter=" + filter + "]";
	}

}