package com.sgtech.news_aggregator_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.service.NewsSourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/news-sources/")
public class NewsSourceController {

    private final NewsSourceService newsSourceService; // replace with interface

    public NewsSourceController(NewsSourceService newsSourceService) {
        this.newsSourceService = newsSourceService;
    }

    @PostMapping("save")
    public String postMethodName(@RequestBody NewsSourceDto newsSource) {
        newsSourceService.addNewsSource(newsSource, "API Request");
        return "News source added successfully";
    }
    

}
