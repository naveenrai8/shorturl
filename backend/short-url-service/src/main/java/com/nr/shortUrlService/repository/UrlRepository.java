package com.nr.shortUrlService.repository;

import com.nr.shortUrlService.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlMapping, String> {
}
