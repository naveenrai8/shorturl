package com.nr.shortUrlService.service;

import com.nr.shortUrlService.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShortUrlGenerator {
    private static final char[] ALPHANUMERIC_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static final SecureRandom random = new SecureRandom();
    @Value("${app.shortUrlLength:10}")
    private int shortUrlLength;
    private final UrlRepository urlRepository;

    public String generateRandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1.");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length);
            sb.append(ALPHANUMERIC_CHARS[randomIndex]);
        }
        return sb.toString();
    }

    public String generate(String url) {
        var shortUrl = generateRandomString(shortUrlLength);
        while (urlRepository.existsById(shortUrl)) {
            log.info("Short url {} already exists. Generating new one.", shortUrl);
            shortUrl = generateRandomString(shortUrlLength);
        }
        return shortUrl;
    }

}
