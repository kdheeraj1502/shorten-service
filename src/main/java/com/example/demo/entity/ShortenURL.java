package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(schema = "URL_SHORTENER", name = "shorten_url")
public class ShortenURL {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "long_url", length = 1000)
    private String longURL;

    @Column(name = "short_url")
    private String shortURL;
}
