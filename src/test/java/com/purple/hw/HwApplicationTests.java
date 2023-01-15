package com.purple.hw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HwApplicationTests {

	@Value("${instagram.endpoints.url}")
	private String instaUrl;
	@Value("${twitter.endpoints.url}")
	private String twitUrl;
	@Value("${vimeo.endpoints.url}")
	private String vimUrl;
	@Value("${youtube.endpoints.url}")
	private String youUrl;

	@Test
	void contextLoads() {
		System.out.println("Instagram URL >> " + instaUrl);
		System.out.println("Twitter URL >> " + twitUrl);
		System.out.println("Vimeo URL >> " + vimUrl);
		System.out.println("Youtube >> " + youUrl);
	}

}
