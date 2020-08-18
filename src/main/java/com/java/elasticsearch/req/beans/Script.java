package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Script {

	@JsonProperty("script")
    private final String script;
	
	@JsonProperty("params")
	private final Params params;
	
	
	
	@SuppressWarnings("unused")
	private Script(){
		this(null,null);
	}
	public Script(final String script, final Params params) {
		this.script = script;
		this.params = params;
	}

	public static Script withScript(final String script){
		return new Script(script, null);
	}
	public static Script withScriptAndParam(final String script, final Params params){
		return new Script(script, params);
	}
	
	public static Script withScriptAndOneParamValue(final String script, final Params params){
		return new Script(script, params);
	}
	
	public String getScript() {
		return script;
	}

	public Params getParams() {
		return params;
	}
	@Override
	public String toString() {
		return "Script [script=" + script + ", params=" + params + "]";
	}
	
	
}
