package com.destin.springcourse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.json.JSONObject;

import java.io.IOException;
public class RequestManager {
    private static final String URL = "https://emailvalidation.abstractapi.com/v1/?api_key=f3d064ba905b435db279d0fbe551aa2e&email=";

    public static boolean mailValidityVerification(String email) throws IOException {
        final HttpGet request = new HttpGet(URL + email);
        CloseableHttpClient client = HttpClients.createDefault();
        JSONObject jsonObject = new JSONObject(client.execute(request, new BasicHttpClientResponseHandler()));
        JSONObject isValid = (JSONObject) jsonObject.get("is_valid_format");
        return (boolean) isValid.get("value");
    }
}