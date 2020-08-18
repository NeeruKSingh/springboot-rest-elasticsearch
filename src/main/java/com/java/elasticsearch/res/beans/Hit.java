
package com.java.elasticsearch.res.beans;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.elasticsearch.req.beans.Source;

@JsonInclude(Include.NON_NULL)
public class Hit {

	@JsonProperty("_index")
    private final String index;
	
	@JsonProperty("_type")
    private final String type;
	
	@JsonProperty("_id")
    private final String id;
	
	@JsonProperty("_score")
    private final Object score;
	
	@JsonProperty("_source")
    private final Source source;
	
	@JsonProperty("sort")
    private final List<Long> sort;

	@SuppressWarnings("unused")
	private Hit(){
		this(null,null,null,null,null,null);
	}
	
	public Hit(final String index, final String type, final String id, final Object score,
			final Source source, final List<Long> sort) {
		super();
		this.index = index;
		this.type = type;
		this.id = id;
		this.score = score;
		this.source = source;
		this.sort = sort;
	}

	public String getIndex() {
		return index;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public Object getScore() {
		return score;
	}

	public Source getSource() {
		return source;
	}

	public List<Long> getSort() {
		return sort;
	}

	@Override
	public String toString() {
		return "Hit [index=" + index + ", type=" + type + ", id=" + id
				+ ", score=" + score + ", source=" + source + ", sort=" + sort
				+ "]";
	}
	

}
