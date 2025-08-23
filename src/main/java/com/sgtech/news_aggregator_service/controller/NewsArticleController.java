package com.sgtech.news_aggregator_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgtech.news_aggregator_service.dto.NewsArticleDto;
import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.service.NewsArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/news-articles/")
public class NewsArticleController {

    private final NewsArticleService newsArticleService;

    public NewsArticleController(NewsArticleService newsArticleService) {
        this.newsArticleService = newsArticleService;
    }
    @PostMapping("save")
    public String saveNewsArticle(@Valid @RequestBody NewsArticleDto newsArticle,
            @RequestHeader("request-source") String requestSource) {
        newsArticleService.saveNewsArticle(newsArticle, requestSource);
        return "News article added successfully";
    }
}
