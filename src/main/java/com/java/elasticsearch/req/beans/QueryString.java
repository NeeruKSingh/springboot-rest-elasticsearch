package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QueryString {
	
@JsonProperty("query")
private String query;


@JsonProperty("default_operator")
private String default_operator;

private QueryString(){
	this(null,null);
}

public QueryString(String query,String default_operator){
	this.query=query;
	this.default_operator=default_operator;
}


public static QueryString withQuery(String query){
	return new QueryString(query,null);
}


public static QueryString withDefaultOperator(String default_operator){
	return new QueryString(null, default_operator);
}

public static QueryString withQueryAndDefaultOperator(String query,String default_operator){
	return new QueryString( query, default_operator);
}

public String getQuery() {
	return query;
}

public String getDefault_operator() {
	return default_operator;
}

	
	
}
