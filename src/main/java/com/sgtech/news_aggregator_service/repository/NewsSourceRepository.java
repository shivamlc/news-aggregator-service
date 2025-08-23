package com.sgtech.news_aggregator_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgtech.news_aggregator_service.entity.NewsSourceEntity;

@Repository
public interface NewsSourceRepository extends JpaRepository<NewsSourceEntity, UUID> {
    // This interface will automatically have methods for CRUD operations
    // on NewsSourceEntity due to the JpaRepository inheritance.
    // Additional custom query methods can be defined here if needed.

}
