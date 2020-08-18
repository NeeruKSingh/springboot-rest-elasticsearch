
package com.java.elasticsearch.res.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SearchResponse {

	@JsonProperty("took")
    private final Integer took;
    
	@JsonProperty("timed_out")
    private final Boolean timedOut;
    
	@JsonProperty("_shards")
    private final Shards shards;
    
	@JsonProperty("hits")
    private final Hits hits;
	
	

	@SuppressWarnings("unused")
	private SearchResponse(){
		this(null, null,null,null);
	}
	
    
    public SearchResponse(Integer took, Boolean timedOut, Shards shards,
			Hits hits) {
		super();
		this.took = took;
		this.timedOut = timedOut;
		this.shards = shards;
		this.hits = hits;
	}




	public Integer getTook() {
        return took;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }
   
    public Shards getShards() {
		return shards;
	}

	
    public Hits getHits() {
        return hits;
    }

	@Override
	public String toString() {
		return "SearchResponse [took=" + took + ", timedOut=" + timedOut
				+ ", shards=" + shards + ", hits=" + hits + "]";
	}
    

}
