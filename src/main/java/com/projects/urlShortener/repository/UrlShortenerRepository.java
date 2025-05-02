package com.projects.urlShortener.repository;

import com.projects.urlShortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortUrl);

    Url findByOriginUrl(String originalUrl);
}
