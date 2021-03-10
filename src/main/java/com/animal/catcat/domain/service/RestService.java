package com.animal.catcat.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.animal.catcat.domain.repository.Url;

@Service
public class RestService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	// APIの実行
	public Url apiExecute() {
		return restTemplate.getForObject("https://aws.random.cat/meow", Url.class);
	}

}
