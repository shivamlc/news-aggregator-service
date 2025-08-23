package com.sgtech.news_aggregator_service.mapper;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.sgtech.news_aggregator_service.dto.NewsArticleDto;
import com.sgtech.news_aggregator_service.entity.NewsArticleEntity;

public class NewsArticleMapper {

    public static NewsArticleEntity mapToEntity(NewsArticleDto newsArticleDto) {
        if (newsArticleDto == null) {
            return null;
        }
        
        NewsArticleEntity entity = NewsArticleEntity.builder()
                .articleTitle(newsArticleDto.getTitle())
                .articleDescription(newsArticleDto.getDescription())
                .articleContent(newsArticleDto.getContent())
                .articleUrl(newsArticleDto.getUrl())
                .imageUrl(newsArticleDto.getUrl())
                .build();

        // For custom format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(newsArticleDto.getPublishedAt(), formatter);
            entity.setPublishedAt(zonedDateTime);

        return entity;
    } 

}
