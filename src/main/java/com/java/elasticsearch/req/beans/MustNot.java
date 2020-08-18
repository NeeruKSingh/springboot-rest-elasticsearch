
package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MustNot {

    @JsonProperty("term")
    private Term term;
    
    @JsonProperty("terms")
    private Terms terms;
   
    @JsonProperty("match")
    private Match match;
    /**
     * No args constructor for use in serialization
     * 
     */
    private MustNot() {
    	this(null,null,null);
    }

    /**
     * 
     * @param term
     */
    public MustNot(Term term,Terms terms,Match match) {
        this.term = term;
        this.terms=terms;
        this.match=match;
    }

    /**
     * 
     * @return
     *     The term
     */
    @JsonProperty("term")
    public Term getTerm() {
        return term;
    }
    
    

    public Terms getTerms() {
		return terms;
	}

	/**
     * 
     * @param term
     *     The term
     */
    @JsonProperty("term")
    public void setTerm(Term term) {
        this.term = term;
    }

    public static MustNot withTerm(final Term term) {
       return new MustNot(term,null,null);
       
    }

    public static MustNot withTerms(final Terms terms) {
        return new MustNot(null,terms,null);
        
     }
    
    public static MustNot withMatch(final Match match){
    	return new MustNot(null,null,match);
    }
    @Override
	public String toString() {
		return "MustNot [term=" + term + "]";
	}
}
