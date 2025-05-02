package com.projects.urlShortener.controller;

import com.projects.urlShortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("originalUrl") String originalUrl, Model model, HttpServletRequest request) {
        String shortCode = urlShortenerService.shortenUrl(originalUrl);
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String fullShortUrl = baseUrl + "/" + shortCode;

        model.addAttribute("shortUrl", fullShortUrl);
        return "homepage";
    }

    @GetMapping("/{shortCode}")
    public void redirectToOriginalUrl(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String originalUrl = urlShortenerService.getOriginalUrl(shortCode);
        System.out.println(originalUrl);
        System.out.println(originalUrl);
        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Short URL not found");
        }
    }
}
