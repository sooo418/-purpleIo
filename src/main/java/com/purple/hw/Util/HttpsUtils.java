package com.purple.hw.Util;

import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

@Component
public class HttpsUtils {

    private final static String GET = "GET";
    private final static String UTF8 = "UTF-8";

    public String httpsRequestGet(String strUrl) throws IOException {

        try {
            URL url = new URL(strUrl);
            HttpsURLConnection httpsUrlCon = (HttpsURLConnection) url.openConnection();

            httpsUrlCon.setRequestMethod(GET);
            httpsUrlCon.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpsUrlCon.setConnectTimeout(5000);
            httpsUrlCon.setReadTimeout(5000);

            Charset charset = Charset.forName(UTF8);

            BufferedReader br = new BufferedReader(new InputStreamReader(httpsUrlCon.getInputStream(), UTF8));

            String line = "";
            StringBuffer sb = new StringBuffer();

            while( (line = br.readLine()) != null ) {
                sb.append(line);
            }

            br.close();

            System.out.println(sb.toString());

            return sb.toString();
        } catch (MalformedURLException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }
}
