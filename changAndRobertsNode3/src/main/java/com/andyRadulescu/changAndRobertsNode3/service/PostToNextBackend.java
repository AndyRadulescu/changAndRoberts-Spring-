package com.andyRadulescu.changAndRobertsNode3.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostToNextBackend {
    public Integer postToNextNode(int value, String type) {
        final String uri = "http://localhost:8081/" + type;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(uri, value, Integer.class);
    }

    public Integer finishTowerControl(int value) {
        final String uri = "http://localhost:8090/finishTowerControl";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(uri, value, Integer.class);
    }
}
