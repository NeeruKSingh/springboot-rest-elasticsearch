package com.java.elasticsearch.req.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Bool {

	@JsonProperty("must")
	private final List<Must> must;

	@JsonProperty("must_not")
	private final List<MustNot> mustNot;

	@JsonProperty("should")
	private final List<Should> should;
	
	@JsonProperty("filter")
	private final Filter filter;

	@SuppressWarnings("unused")
	private Bool() {
		this(null, null, null,null);
	}

	public Bool(final List<Must> must, final List<MustNot> mustNot,
			final List<Should> should,Filter filter) {
		this.must = must;
		this.mustNot = mustNot;
		this.should = should;
		this.filter=filter;
	}

	public List<Must> getMust() {
		return must;
	}


	public List<MustNot> getMustNot() {
		return mustNot;
	}

	public List<Should> getShould() {
		return should;
	}

	public static Bool withMustNot(final List<MustNot> mustNot) {
		return new Bool(null, mustNot, null,null);
	}

	public static Bool withMust(final List<Must> must) {
		return new Bool(must, null, null,null);
	}

	public static Bool withMustAndMustNotAndShould(final List<Must> must,
			final List<MustNot> mustNot, final List<Should> should) {
		return new Bool(must, mustNot, should,null);
	}
	
	public static Bool withMustAndMustNotAndFilter(final List<Must> must,
			final List<MustNot> mustNot, final Filter filter) {
		return new Bool(must, mustNot, null,filter);
	}
	
	public static Bool withMustAndMustNot(final List<Must> must,
			final List<MustNot> mustNot) {
		return new Bool(must, mustNot, null,null);
	}

	@Override
	public String toString() {
		return "Bool [must=" + must + ", mustNot=" + mustNot + ", should="
				+ should + "]";
	}

}
