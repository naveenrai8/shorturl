package com.nr.shortUrlService.controller;

import com.nr.shortUrlService.dto.UrlDto;
import com.nr.shortUrlService.exception.ShortUrlNotFoundException;
import com.nr.shortUrlService.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getLongUrl(@PathVariable String shortUrl) throws ShortUrlNotFoundException {
        var urlMapping = this.urlService.getLongUrl(shortUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", urlMapping.getLongUrl());
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        return ResponseEntity.status(301).headers(headers).build();
    }

    @PostMapping("/")
    public ResponseEntity<String> createShortUrl(@Valid @RequestBody UrlDto urlDto) {
        var shortUrl = this.urlService.getShortUrl(urlDto);
        return ResponseEntity.ok(shortUrl);
    }
}
