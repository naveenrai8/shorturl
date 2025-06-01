package com.nr.shortUrlService.service;

import com.nr.shortUrlService.dto.UrlDto;
import com.nr.shortUrlService.exception.ShortUrlNotFoundException;
import com.nr.shortUrlService.model.UrlMapping;
import com.nr.shortUrlService.repository.UrlRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortUrlGenerator shortUrlGenerator;

    public UrlMapping getLongUrl(String shortUrl) throws ShortUrlNotFoundException {
        // check in case if url is present
        var urlMapping = this.urlRepository.findById(shortUrl);
        log.info("UrlMapping: {}", urlMapping);
        return urlMapping.orElseThrow(() ->
                new ShortUrlNotFoundException("Short url with name: ")
        );
    }

    public String getShortUrl(@Valid UrlDto urlDto) {
        var shortUrl = this.shortUrlGenerator.generate(urlDto.url());
        var urlMapping = UrlMapping.builder()
                .shortUrl(shortUrl)
                .longUrl(urlDto.url())
                .build();
        this.urlRepository.save(urlMapping);
        return shortUrl;
    }
}
