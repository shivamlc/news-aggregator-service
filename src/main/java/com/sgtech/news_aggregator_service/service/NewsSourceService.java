package com.sgtech.news_aggregator_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.entity.NewsSourceEntity;
import com.sgtech.news_aggregator_service.repository.NewsSourceRepository;

@Service
public class NewsSourceService {

    private final NewsSourceRepository newsSourceRepository;

    public NewsSourceService(NewsSourceRepository newsSourceRepository) {
        this.newsSourceRepository = newsSourceRepository;
    }

    public void addNewsSource(NewsSourceDto newsSource, String requestSource) {

        NewsSourceEntity entity = new NewsSourceEntity();
        entity.setCategory(newsSource.getCategory());
        entity.setLanguage(newsSource.getLanguage());
        entity.setCountry(newsSource.getCountry());
        entity.setName(newsSource.getName());
        entity.setDescription(newsSource.getDescription());
        entity.setUrl(newsSource.getUrl());
        entity.setExternalId(newsSource.getId());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setCreatedBy(requestSource);

        newsSourceRepository.save(entity);

    }

}
