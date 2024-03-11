package com.example.demo.repository;

import com.example.demo.entity.ShortenURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShortenURLRepository extends JpaRepository<ShortenURL, UUID> {
    Optional<ShortenURL> findByLongURL(final String longURL);
    Optional<ShortenURL> findByShortURL(final String shortURL);
}
