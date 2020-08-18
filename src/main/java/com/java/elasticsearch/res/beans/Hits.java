package com.java.elasticsearch.res.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Hits {

	
	@JsonProperty("total")
	private final Integer total;

	@JsonProperty("max_score")
	private final Object maxScore;
	
	@JsonProperty("hits")
	private final List<Hit> hits;

	@SuppressWarnings("unused")
	private Hits(){
		this(null,null,null);
	}
	public Hits(final Integer total, final Object maxScore, final List<Hit> hits) {
		super();
		this.total = total;
		this.maxScore = maxScore;
		this.hits = hits;
	}

	public Integer getTotal() {
		return total;
	}

	public Object getMaxScore() {
		return maxScore;
	}

	public List<Hit> getHits() {
		return hits;
	}

	@Override
	public String toString() {
		return "Hits [total=" + total + ", maxScore=" + maxScore + ", hits="
				+ hits + "]";
	}

	
}
