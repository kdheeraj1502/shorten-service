package com.example.demo.service;

import com.example.demo.response.ShortenURLResponse;

import java.net.URISyntaxException;

public interface ShortenURLService {

    ShortenURLResponse shortTheURL(final String longURL);
    String findOriginalURL(final String shortUrl);

    //  ResponseEntity<Object> redirect(final String longURL) throws URISyntaxException;
}
