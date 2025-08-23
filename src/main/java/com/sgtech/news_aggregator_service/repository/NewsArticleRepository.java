package com.sgtech.news_aggregator_service.repository;

import org.springframework.stereotype.Repository;

import com.sgtech.news_aggregator_service.entity.NewsArticleEntity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticleEntity, UUID> {

}
