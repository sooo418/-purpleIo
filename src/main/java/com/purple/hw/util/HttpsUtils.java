package com.purple.hw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class HttpsUtils {
    Logger logger = LoggerFactory.getLogger(HttpsUtils.class);

    private final static String GET = "GET";

    public String httpsRequestGet(String strUrl) throws IOException {
        HttpsURLConnection httpsUrlCon = null;
        BufferedReader br = null;
        try {
            URL url = new URL(strUrl);
            httpsUrlCon = (HttpsURLConnection) url.openConnection();

            httpsUrlCon.setRequestMethod(GET);
            httpsUrlCon.setRequestProperty("Content-Type", "application/json");
            httpsUrlCon.setConnectTimeout(5000);
            httpsUrlCon.setReadTimeout(5000);

            br = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream(), StandardCharsets.UTF_8));

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        } catch (IOException e) {
            logger.error("Https Status Code >> " + httpsUrlCon.getResponseCode());
            logger.error("Https Status Message >> " + httpsUrlCon.getResponseMessage());
            throw new IOException(httpsUrlCon.getResponseCode() + "");
        } finally {
            if (br != null) br.close();
        }
    }
}