package com.purple.hw.connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purple.hw.constants.EmbedChannelType;
import com.purple.hw.domain.Embed;
import com.purple.hw.util.HttpsUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
    // 채널 endpoint url 맵
    private HashMap<String, String> channelEndPointMap = null;
    // 채널리스트
    @PostConstruct
    private void init() {
        channelEndPointMap = new HashMap<>() {
            {
                put(EmbedChannelType.YOUTUBE.getCode(), yEndpoint);
                put(EmbedChannelType.TWITTER.getCode(), tEndpoint);
                put(EmbedChannelType.VIMEO.getCode(), vEndpoint);
            }
        };
    }

    private final HttpsUtils httpsUtils;

    public EmbedConnector(HttpsUtils httpsUtils) {
        this.httpsUtils = httpsUtils;
    }

    public Embed callEmbedApi(Embed embed) throws IOException {
        //ObjectMapper - json을 객체로 변환해주기 위해 호출
        ObjectMapper mapper = new ObjectMapper();

        //입력받은 Url을 urlencode형식으로 인코딩
        String url = URLEncoder.encode(embed.getUrl(), StandardCharsets.UTF_8);

        //url에서 채널 조회
        EmbedChannelType embedChannelType = EmbedChannelType.getUrlEmbedType(url);

        //채널에 맞는 endpoint url을 가져온다.
        String endpointUrl = channelEndPointMap.get( embedChannelType.getCode() );

        /* oEmbed API를 호출할 url 생성
            기본 반환값이 json 형식이므로 format 생략 */
        String callUrl = endpointUrl + "?url=" + url;

        //API 호출
        String jsonData = httpsUtils.httpsRequestGet(callUrl);

        return mapper.readValue(jsonData, Embed.getClass( embedChannelType ));
    }
}
