package com.example.demo.service.impl;

import com.example.demo.entity.ShortenURL;
import com.example.demo.repository.ShortenURLRepository;
import com.example.demo.response.ShortenURLResponse;
import com.example.demo.service.ShortenURLService;
import com.example.demo.service.UID;
import com.example.demo.utility.Base62Convertor;
import com.example.demo.utility.ShortenURlUtils;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ShortenURLServiceImpl implements ShortenURLService {
    private final ShortenURLRepository shortenURLRepository;

    public ShortenURLServiceImpl(final ShortenURLRepository shortenURLRepository) {
        this.shortenURLRepository = shortenURLRepository;
    }

    public ShortenURLResponse shortTheURL(final String longURL) {
        Optional<ShortenURL> shortenURL = shortenURLRepository.findByLongURL(longURL);
        if(shortenURL.isPresent()) {
            return ShortenURlUtils.createResponse(shortenURL.get().getShortURL());
        }
        BigInteger uniqueId = UID.randomUniqueId();
        String base62 = Base62Convertor.toBase62(uniqueId.longValue());
        storeShortURL(longURL, base62);
        return ShortenURlUtils.createResponse(base62);
    }

    private void storeShortURL(final String longURL, final String base62) {
        ShortenURL shortenURL = new ShortenURL();
        shortenURL.setShortURL(base62);
        shortenURL.setLongURL(longURL);
        shortenURLRepository.save(shortenURL);
    }

    @Override
    public String findOriginalURL(final String shortUrl) {
        Optional<ShortenURL> shortenURL = shortenURLRepository.findByShortURL(shortUrl);
        if(shortenURL.isPresent()){
            return shortenURL.get().getLongURL();
        }
        throw new RuntimeException("please create the short URL");
    }
}
