package com.sgtech.news_aggregator_service.mapper;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.entity.NewsSourceEntity;

public class NewsSourceMapper {

    public static NewsSourceDto toDto(NewsSourceEntity entity) {
        if (entity == null) {
            return null;
        }
        NewsSourceDto dto = NewsSourceDto.builder()
                .id(entity.getExternalId())
                .name(entity.getName())
                .description(entity.getDescription())
                .url(entity.getUrl())
                .category(entity.getCategory())
                .language(entity.getLanguage())
                .build();
        return dto;
    }

    public static NewsSourceEntity toEntity(NewsSourceDto newsSourceDto) {
        if (newsSourceDto == null) {
            return null;
        }
         NewsSourceEntity entity = NewsSourceEntity.builder()
                .externalId(newsSourceDto.getId())
                .name(newsSourceDto.getName())
                .description(newsSourceDto.getDescription())
                .url(newsSourceDto.getUrl())
                .country(newsSourceDto.getCountry())
                .category(newsSourceDto.getCategory())
                .language(newsSourceDto.getLanguage())
                .build();

        return entity;
    
    }

}
