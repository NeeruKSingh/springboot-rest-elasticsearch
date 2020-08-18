package com.java.elasticsearch.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.elasticsearch.req.beans.Document;
import com.java.elasticsearch.req.beans.ElasticSearch;
import com.java.elasticsearch.req.beans.Script;
import com.java.elasticsearch.req.beans.Source;
import com.java.elasticsearch.res.beans.Hit;
import com.java.elasticsearch.res.beans.SearchResponse;

public class ElasticSearchHttpClient {

	private String baseUrl;
	private ElasticSearchURLs searchURLs;
	private RestTemplate restTemplate;

	public ElasticSearchHttpClient(final String baseUrl, RestTemplate restTemplate) {
		this.baseUrl = baseUrl;
		this.restTemplate = restTemplate;
		this.searchURLs = new ElasticSearchURLs();
	}

	private static HttpHeaders getHttpHeaders() {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public List<Source> getUsers(final ElasticSearch es, final Integer offset, final Integer limit, final String tag) {
		List<Source> users = new ArrayList<Source>();
		final HttpEntity<ElasticSearch> reqEntity = new HttpEntity<ElasticSearch>(es, getHttpHeaders());
		try {
			final ResponseEntity<SearchResponse> resEntity = restTemplate
					.exchange(searchURLs.getSearchUrl(offset, limit), HttpMethod.POST, reqEntity, SearchResponse.class);
			final List<Hit> hitList = resEntity.getBody().getHits().getHits();
			for (Hit hit : hitList) {
				users.add(hit.getSource());
			}
		} catch (Exception e) {
			System.out.println("Error found: " + e.getMessage());
		}
		return users;
	}

	public void addDocument(final Source source) {

		final HttpEntity<Source> reqEntity = new HttpEntity<Source>(source, getHttpHeaders());

		try {
			final ResponseEntity<String> resEntity = restTemplate.exchange(
					searchURLs.getAddDoucumentUrl(source.getUserId()), HttpMethod.POST, reqEntity, String.class);
			System.out.println("User added response:" + resEntity.getBody());
		} catch (Exception e) {
			System.out.println("Error found: " + e.getMessage());
		}
	}

	public Optional<Source> getUserDocument(final String userId) {
		final HttpEntity<String> reqEntity = new HttpEntity<String>(getHttpHeaders());
		try {
			final ResponseEntity<Source> resEntity = restTemplate.exchange(searchURLs.getUserDocumentUrl(userId),
					HttpMethod.GET, reqEntity, Source.class);
			return Optional.ofNullable(resEntity.getBody());
		} catch (Exception e) {
			System.out.println("ELASTICSEARCH :=============== ERROR WHILE GETTING USER DOCUMENT============= " + e);
		}
		return Optional.empty();
	}

	public void updateDocumentWithScript(final Long userId, final Script script, final String tag) {

		final Document doc = Document.withScript(script);
		final HttpEntity<Document> reqEntity = new HttpEntity<Document>(doc, getHttpHeaders());
		try {
			System.out.println("[ Json: " + new ObjectMapper().writeValueAsString(doc) + " ]");

			final ResponseEntity<String> resEntity = restTemplate.exchange(searchURLs.getUpdateDoucumentUrl(userId),
					HttpMethod.POST, reqEntity, String.class);
			System.out.println("Update response" + tag + "Json: " + new ObjectMapper().writeValueAsString(doc)
					+ "[status : " + resEntity.getStatusCode() + " ]");
		} catch (Exception e) {
			System.out.println(" ERROR WHILE UPDATE: " + e.getLocalizedMessage());
		}
	}

	public Boolean deleteUserDocument(final String userId) {

		final HttpEntity<String> reqEntity = new HttpEntity<String>(getHttpHeaders());
		try {
			final ResponseEntity<Source> resEntity = restTemplate.exchange(searchURLs.getDeleteDoucumentUrl(userId),
					HttpMethod.DELETE, reqEntity, Source.class);

			if (resEntity.getStatusCode() == HttpStatus.OK) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ELASTICSEARCH:=============== ERROR WHILE DELETING USER DOCUMENT ==============" + e);
		}
		return false;
	}

	public boolean deleteOldIndex() {
		final HttpEntity<String> reqEntity = new HttpEntity<String>(getHttpHeaders());
		try {
			final ResponseEntity<String> resEntity = restTemplate.exchange(searchURLs.getDeleteIndexUrl(),
					HttpMethod.DELETE, reqEntity, String.class);
			if (resEntity.getStatusCode() == HttpStatus.OK) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ELASTICSEARCH:=============== ERROR WHILE DELETING INDEX ==============" + e);
		}
		return false;
	}

	private class ElasticSearchURLs {

		public static final String searchFrom = "_search?from=";
		public static final String search = "_search";
		public static final String size = "&size=";
		public static final String update = "/_update";
		public static final String exist = "_search/exists";
		public static final String source = "/_source";
		public static final String RETRY = "?retry_on_conflict=5";

		public String getSearchUrl(final Integer offset, final Integer limit) {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(searchFrom).append(offset).append(size)
					.append(limit).toString();
		}

		public String getUserProperityUrl() {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(search).toString();
		}

		public String getUserDocumentUrl(String userId) {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(userId).append(source).toString();
		}

		public String getAddDoucumentUrl(final String userId) {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(userId).toString();
		}

		public String getDeleteDoucumentUrl(final String userId) {
			return getAddDoucumentUrl(userId);
		}

		public String getDeleteIndexUrl() {
			return new StringBuilder().append(getIndexUrl()).toString();
		}

		public String getUpdateDoucumentUrl(final Long userId) {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(userId).append(update).append(RETRY)
					.toString();
		}

		public String getExistDoucumentUrl() {
			return new StringBuilder().append(getBaseUrlForFreemium()).append(exist).toString();
		}

		public String getBaseUrlForFreemium() {
			return new StringBuilder(baseUrl).append("/").append(Index.USERS).append("/").append(Index.Type.USERS)
					.append("/").toString();
		}

		public String getIndexUrl() {
			return new StringBuilder(baseUrl).append("/").append(Index.USERS).toString();

		}
	}
}
