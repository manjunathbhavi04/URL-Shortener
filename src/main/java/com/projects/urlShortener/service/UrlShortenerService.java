package com.projects.urlShortener.service;

import com.projects.urlShortener.model.Url;
import com.projects.urlShortener.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 6;
    private final Random random = new Random();

    public String shortenUrl(String originalUrl) {

        //check if the originalUrl is already present or not
        // to avoid generating unique code every time
        Url u = urlShortenerRepository.findByOriginUrl(originalUrl);
        if(u != null) {
            return u.getShortCode();
        }

        String shortCode = generateShortCode();

        Url url = Url.builder()
                .originUrl(originalUrl)
                .shortCode(shortCode)
                .createdAt(LocalDateTime.now())
                .build();

        urlShortenerRepository.save(url);
        return shortCode;
    }

    public String getOriginalUrl(String shortUrl) {
        Optional<Url> originalUrl = urlShortenerRepository.findByShortCode(shortUrl); //get the original url with the use of shortcode
        return originalUrl.map(Url::getOriginUrl).orElse(null);
    }

    private String generateShortCode() {

        String code;

        do {
            code = generateRandomCode();
        }while(urlShortenerRepository.findByShortCode(code).isPresent());

        return code;

    }

    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for(int i = 0 ; i < CODE_LENGTH; ++i) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
