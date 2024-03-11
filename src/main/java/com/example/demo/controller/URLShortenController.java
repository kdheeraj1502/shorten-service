package com.example.demo.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.example.demo.response.ShortenURLResponse;
import com.example.demo.service.ShortenURLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1")
public class URLShortenController {
    private final ShortenURLService shortenURLService;

    public URLShortenController(final ShortenURLService shortenURLService) {
        this.shortenURLService = shortenURLService;
    }

    @PostMapping("/data/shorten")
    public ResponseEntity<ShortenURLResponse> shortTheURL(@RequestParam(value = "longURL") final String longURL) {
        ShortenURLResponse response = shortenURLService.shortTheURL(longURL);
        return ok(response);
    }

    @GetMapping("/shortUrl")
    public RedirectView findOriginalURL(@RequestParam(value = "shortURL") final String shortURL) {
        String longURL = shortenURLService.findOriginalURL(shortURL);
        if(longURL != null) {
            RedirectView redirectView = new RedirectView(longURL);
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            return redirectView;
        } else {
            return new RedirectView("/", true);
        }
    }
}
