package com.sgtech.news_aggregator_service.service;

import org.springframework.stereotype.Service;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.repository.NewsSourceRepository;

@Service
public class NewsSourceService {

    private final NewsSourceRepository newsSourceRepository;

    public NewsSourceService(NewsSourceRepository newsSourceRepository) {
        this.newsSourceRepository = newsSourceRepository;
    }

    public void addNewsSource(NewsSourceDto newsSource) {
        // Convert NewsSourceDto to NewsSourceEntity if necessary
        // and save it to the repository
        // Assuming NewsSourceDto has a method to convert to NewsSourceEntity
        // NewsSourceEntity entity = newsSource.toEntity();
        // newsSourceRepository.save(entity);
    }

}
