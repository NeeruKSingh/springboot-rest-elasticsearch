package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Prefix {

	private final String name;

	@SuppressWarnings("unused")
	private Prefix() {
		this(null);
  }
	
   public Prefix(String name) {

		this.name = name;
	}

	public static Prefix withName(String name) {
		return new Prefix(name);
	}

	public String getName() {
		return name;
	}

}
