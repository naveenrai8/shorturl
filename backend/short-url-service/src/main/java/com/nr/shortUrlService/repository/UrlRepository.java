package com.nr.shortUrlService.repository;

import com.nr.shortUrlService.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping, String> {
    boolean existsByLongUrl(String longUrl);
    Optional<UrlMapping> findByLongUrl(String longUrl);
}
