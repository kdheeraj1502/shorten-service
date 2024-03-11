package com.example.demo.utility;

import com.example.demo.response.ShortenURLResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ShortenURlUtils {
    public static ShortenURLResponse createResponse(final String shortURL) {
        ShortenURLResponse shortenURLResponse = new ShortenURLResponse();
        shortenURLResponse.setShortURL(shortURL);
        shortenURLResponse.setStatus("Success");
        return shortenURLResponse;
    }
}
