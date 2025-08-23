package com.sgtech.news_aggregator_service.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

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

    public void addNewsSources(List<NewsSourceDto> newsSourceDtoList, String requestSource) {
        newsSourceDtoList.stream().forEach(newsSource -> {
            NewsSourceEntity entity = NewsSourceMapper.toEntity(newsSource);
            entity.setCreatedAt(ZonedDateTime.now(ZoneId.systemDefault()));
            entity.setCreatedBy(requestSource);
            newsSourceRepository.save(entity);
        });
    }

}
