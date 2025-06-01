package com.nr.shortUrlService.exception;

public class ShortUrlNotFoundException extends Throwable {
    public ShortUrlNotFoundException(String message) {
        super(message);
    }
}
