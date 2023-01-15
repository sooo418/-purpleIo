package com.purple.hw.service;

import com.purple.hw.connector.EmbedConnector;
import com.purple.hw.domain.Embed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmbedServiceImplTest {

    @Value("${youtube.endpoints.test_url}")
    String youtubeTestUrl;
    @Value("${twitter.endpoints.test_url}")
    String twitterTestUrl;
    @Value("${vimeo.endpoints.test_url}")
    String vimeoTestUrl;

    @Autowired
    EmbedConnector embedConnector;

    @Test
    void urlEncode() throws UnsupportedEncodingException {
        String urlendcode = URLEncoder.encode(youtubeTestUrl, StandardCharsets.UTF_8);

        assertThat("https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DdBD54EZIrZo").isEqualTo(urlendcode);
    }

    @Test
    void 유투브() throws IOException {
        //given
        Embed embed = new Embed();
        embed.setUrl(youtubeTestUrl);

        //when
        Embed test = embedConnector.callEmbedApi(embed);

        //then
        assertThat("YouTube").isEqualTo(test.getProviderName());
    }

    @Test
    void 트위터() throws IOException {
        //given
        Embed embed = new Embed();
        embed.setUrl(twitterTestUrl);

        //when
        Embed test = embedConnector.callEmbedApi(embed);

        //then
        assertThat("Twitter").isEqualTo(test.getProviderName());
    }

    @Test
    void 비메오() throws IOException {
        //given
        Embed embed = new Embed();
        embed.setUrl(vimeoTestUrl);

        //when
        Embed test = embedConnector.callEmbedApi(embed);

        //then
        assertThat("Vimeo").isEqualTo(test.getProviderName());
    }
}