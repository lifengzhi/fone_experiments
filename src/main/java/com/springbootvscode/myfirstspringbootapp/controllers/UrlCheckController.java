package com.springbootvscode.myfirstspringbootapp.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
    private final String SITE_IS_UP = "Site is UP!";
    private final String SITE_IS_DOWN = "Site is down!";
    private final String URL_INCORRECT = "URL is incorrect!";


    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String retMsg = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() / 100 != 2) {
                retMsg = SITE_IS_DOWN;
            }
            else {
                retMsg = SITE_IS_UP;
            }
        } catch (MalformedURLException e) {
            retMsg = URL_INCORRECT;
        } catch (IOException e) {
            retMsg = SITE_IS_DOWN;
        }
        return retMsg;
    }
}
