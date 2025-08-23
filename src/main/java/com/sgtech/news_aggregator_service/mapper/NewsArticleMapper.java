package com.sgtech.news_aggregator_service.mapper;

import java.time.ZonedDateTime;
import java.time.Instant;
import java.time.ZoneId;

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

        // For Zulu time format (Z indicates UTC)
        if (newsArticleDto.getPublishedAt() != null) {
            // Use ISO_INSTANT formatter which properly handles 'Z' as UTC timezone indicator
            Instant instant = Instant.parse(newsArticleDto.getPublishedAt());
            ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
            entity.setPublishedAt(zonedDateTime);
        }

        return entity;
    } 

}
