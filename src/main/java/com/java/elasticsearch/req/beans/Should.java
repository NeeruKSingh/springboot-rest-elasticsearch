package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Should {

@JsonProperty("term")
private final Term term;

@JsonProperty("match")
private final Match match;


@SuppressWarnings("unused")
private Should(){
this(null,null);
}

public Should(final Term term,Match match) {
this.term = term;
this.match=match;
}

public static Should withMatch(Match match){
	return new Should(null,match);
}

public Term getTerm() {
return term;
}

@Override
public String toString() {
return "Should [term=" + term + "]";
}



}