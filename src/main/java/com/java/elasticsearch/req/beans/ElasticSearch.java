
package com.java.elasticsearch.req.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class ElasticSearch {

	@JsonProperty("query")
    private final Query query;
	
	@JsonProperty("filter")
	private final Filter filter;
	
	
	@JsonProperty("_source")
	private final List<String> source;
	
	
	
	
    public ElasticSearch(final Query query, final Filter filter, final List<String> source) {
		super();
		this.query = query;
		this.filter = filter;
		
		this.source=source;
	
	}

	public static ElasticSearch withQuery(final Query query) {
		return new ElasticSearch(query,null,null);
    }
    
    public static ElasticSearch withQueryFilter(final Query query,final Filter filter) {
    	return new ElasticSearch(query,filter,null);
    }
    
    public static ElasticSearch withQueryAndSource(final Query query,final List<String> source) {
    	return new ElasticSearch(query,null,source);
    }
    
   
    
	public Query getQuery() {
		return query;
	}

	public Filter getFilter() {
		return filter;
	}


	public List<String> getSource() {
		return source;
	}

	@Override
	public String toString() {
		return "ElasticSearch [query=" + query + ", filter=" + filter
				+ ", source=" + source + "]";
	}
    
   

}