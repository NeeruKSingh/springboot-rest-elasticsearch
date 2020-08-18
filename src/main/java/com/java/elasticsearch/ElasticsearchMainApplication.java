package com.java.elasticsearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.java.elasticsearch.helper.ElasticSearchHttpClient;

@SpringBootApplication
@PropertySource("classpath:elasticsearch.properties")
public class ElasticsearchMainApplication {

	
	@Value("${elasticsearch.serverurl}")
	String url;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchMainApplication.class, args);
	}

	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean
	public ElasticSearchHttpClient createbean() {
		RestTemplate restTemplate=createRestTemplate();
		ElasticSearchHttpClient obj = new ElasticSearchHttpClient(url,restTemplate);
		return obj;

	}
	
	
}
