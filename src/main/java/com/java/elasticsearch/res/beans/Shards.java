
package com.java.elasticsearch.res.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Shards {

	@JsonProperty("total")
	
    private final Integer total;
    
	@JsonProperty("successful")
    private final Integer successful;
    
	@JsonProperty("failed")
    private final Integer failed;

	@SuppressWarnings("unused")
	private Shards(){
		this(null, null, null);
	}
   
    public Shards(Integer total, Integer successful, Integer failed) {
		super();
		this.total = total;
		this.successful = successful;
		this.failed = failed;
	}

	public Integer getTotal() {
        return total;
    }
   
    public Integer getSuccessful() {
        return successful;
    }

    public Integer getFailed() {
        return failed;
    }


	@Override
	public String toString() {
		return "Shards [total=" + total + ", successful=" + successful
				+ ", failed=" + failed + "]";
	}
}
