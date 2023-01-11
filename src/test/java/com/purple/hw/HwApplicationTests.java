package com.purple.hw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
		System.out.println(instaUrl + "," + twitUrl + "," + vimUrl + "," + youUrl);
	}

	@Test
	void urlEncode() throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("https://www.youtube.com/watch?v=dBD54EZIrZo", "UTF-8"));

	}
}
