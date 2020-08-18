package com.java.elasticsearch.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.elasticsearch.req.beans.Source;
import com.java.elasticsearch.req.beans.User;

@Component
public class ElasticsearchHelper {

	@Autowired
	ElasticSearchHttpClient esHttpClient;

	public void addDocument(Source source) {
		esHttpClient.addDocument(source);
	}

	public User getUserById(String userId) {
		Optional<Source> source=esHttpClient.getUserDocument(userId);
		if(source.isPresent()) {
			return User.getUser(source.get());
		}
		return null;
	}

}
