package com.sgtech.news_aggregator_service.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgtech.news_aggregator_service.dto.NewsArticleDto;
import com.sgtech.news_aggregator_service.entity.NewsArticleEntity;
import com.sgtech.news_aggregator_service.entity.NewsSourceEntity;
import com.sgtech.news_aggregator_service.mapper.NewsArticleMapper;
import com.sgtech.news_aggregator_service.repository.NewsArticleRepository;
import com.sgtech.news_aggregator_service.repository.NewsSourceRepository;

@Service
public class NewsArticleService {

    private final NewsArticleRepository newsArticleRepository;
    private final NewsSourceRepository newsSourceRepository;

    public NewsArticleService(NewsArticleRepository newsArticleRepository, 
    NewsSourceRepository newsSourceRepository) {
        this.newsArticleRepository = newsArticleRepository;
        this.newsSourceRepository = newsSourceRepository;
    }

    public void saveNewsArticle(NewsArticleDto newsArticleDto, String requestSource) {

        NewsArticleEntity entity = NewsArticleMapper.mapToEntity(newsArticleDto);
        entity.setCreatedAt(ZonedDateTime.now(ZoneId.systemDefault()));
        entity.setCreatedBy(requestSource);
        NewsSourceEntity newsSourceEntity = Optional.ofNullable
        (newsSourceRepository.findByExternalId(
                newsArticleDto.getSource().getId())
        )
        .orElseThrow(() -> new RuntimeException("News source not found"));

        entity.setNewsSource(newsSourceEntity);
        newsArticleRepository.save(entity);

    }

}
