package com.purple.hw.Connector;

import com.purple.hw.Util.HttpsUtils;
import com.purple.hw.domain.Embed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class EmbedConnector {
    @Value("${instagram.endpoints.url}")
    private String iEndpoint;
    @Value("${twitter.endpoints.url}")
    private String tEndpoint;
    @Value("${vimeo.endpoints.url}")
    private String vEndpoint;
    @Value("${youtube.endpoints.url}")
    private String yEndpoint;
    // 채널리스트
    private List<String> channelList = null;
    // 채널 endpoint url 맵
    private HashMap<String, String> channelEndPointMap = null;
    // 채널리스트
    @PostConstruct
    private void init() {
        channelList = Arrays.asList("instagram", "twitter", "vimeo", "youtube");
        channelEndPointMap = new HashMap<>() {
            {
                put("instagram", iEndpoint);
                put("twitter", tEndpoint);
                put("vimeo", vEndpoint);
                put("youtube", yEndpoint);
            }
        };
    }

    private final HttpsUtils httpsUtils;

    public EmbedConnector(HttpsUtils httpsUtils) {
        this.httpsUtils = httpsUtils;
    }

    public Embed callEmbedApi(Embed embed) {
        try {
            // 입력받은 Url을 urlencode형식으로 인코딩
            String url = URLEncoder.encode(embed.getUrl(), "UTF-8");

            // url에서 채널 조회
            Optional<String> channel = channelList.stream()
                    .filter(c -> url.toLowerCase().contains(c))
                    .findAny();

            String endpoint = channelEndPointMap.get(channel.get());

            StringBuilder sb = new StringBuilder();

            // 기본 반환값이 json 형식이므로 format 생략
            sb.append(endpoint)
                    .append("?url=")
                    .append(url);

            String result = httpsUtils.httpsRequestGet(sb.toString());

            return null;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
