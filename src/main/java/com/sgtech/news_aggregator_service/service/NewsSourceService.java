package com.sgtech.news_aggregator_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.entity.NewsSourceEntity;
import com.sgtech.news_aggregator_service.mapper.NewsSourceMapper;
import com.sgtech.news_aggregator_service.repository.NewsSourceRepository;

@Service
public class NewsSourceService {

    private final NewsSourceRepository newsSourceRepository;

    public NewsSourceService(NewsSourceRepository newsSourceRepository) {
        this.newsSourceRepository = newsSourceRepository;
    }

    public void addNewsSource(NewsSourceDto newsSourceDto, String requestSource) {

        NewsSourceEntity entity = NewsSourceMapper.toEntity(newsSourceDto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setCreatedBy(requestSource);
        newsSourceRepository.save(entity);

    }

}
