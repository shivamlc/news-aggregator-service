package com.sgtech.news_aggregator_service.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
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

    //TODO: add validaiton layer to filter out articles with important attributes having null values
    public void saveNewsArticle(List<NewsArticleDto> newsArticleDtoList, String requestSource) {
        newsArticleDtoList.stream().forEach(newsArticleDto -> {
            NewsArticleEntity entity = NewsArticleMapper.mapToEntity(newsArticleDto);
            entity.setCreatedAt(ZonedDateTime.now(ZoneId.systemDefault()));
            entity.setCreatedBy(requestSource);

            if (newsArticleDto.getSource() != null && newsArticleDto.getSource().getId() != null) {
                System.out.println(("\n\n==> SOURCE ID: " + newsArticleDto.getSource().getId()));
                NewsSourceEntity newsSourceEntity = Optional.ofNullable(newsSourceRepository.findByExternalId(
                        newsArticleDto.getSource().getId())).orElse(null);

                entity.setNewsSource(newsSourceEntity);
            }

            newsArticleRepository.save(entity);
        });

    }

}
