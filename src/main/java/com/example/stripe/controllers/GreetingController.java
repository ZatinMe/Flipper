package com.example.stripe.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class GreetingController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/lang")
    public String hello(@RequestHeader("Accept-Language") String headerValue) {
        return headerValue;
    }

    @GetMapping("/extract-all-headers")
    public List<String> extractAllHeaders(HttpServletRequest request) {
        String acceptLanguageHeader = request.getHeader("Accept-Language");
        Set<String> supportedLanguages = new HashSet<>(Arrays.asList("en", "es", "fr"));
        return Arrays.asList(acceptLanguageHeader);

    }
}
