package com.java.elasticsearch.req.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Document {
	
	@JsonProperty("doc")
	private final Source source;
	
	@JsonProperty("script")
    private final Script script;
	
	@SuppressWarnings("unused")
	private Document(){
		this(null, null);
	}

	public Document(final Source source, final Script script) {
		super();
		this.source = source;
		this.script = script;
	}

	public static Document withSource(final Source source) {
		return new Document(source, null);
	}

	public static Document withScript(final Script script) {
		return new Document(null, script);
	}

	public Script getScript() {
		return script;
	}

	public Source getSource() {
		return source;
	}

	@Override
	public String toString() {
		return "Document [source=" + source + ", script=" + script + "]";
	}

}
