//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.elhackaton.appcede.app.reviews;

import java.util.HashMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ReviewClient_
    implements ReviewClient
{

    private RestTemplate restTemplate;
    private String rootUrl;

    public ReviewClient_() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        rootUrl = "http://192.168.1.40";
    }

    @Override
    public Review[] getReviews() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("/api/reviews"), HttpMethod.GET, requestEntity, Review[].class).getBody();
    }

    @Override
    public Review getReview(int id) {
        HashMap<String, Object> urlVariables = new HashMap<String, Object>();
        urlVariables.put("id", id);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(httpHeaders);
        return restTemplate.exchange(rootUrl.concat("/api/reviews/{id}"), HttpMethod.GET, requestEntity, Review.class, urlVariables).getBody();
    }

    @Override
    public void newRewiew(Review review) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Review> requestEntity = new HttpEntity<Review>(review, httpHeaders);
        restTemplate.exchange(rootUrl.concat("/api/reviews"), HttpMethod.POST, requestEntity, null);
    }

}