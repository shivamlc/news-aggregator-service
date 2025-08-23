package com.sgtech.news_aggregator_service.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgtech.news_aggregator_service.enums.Category;
import com.sgtech.news_aggregator_service.enums.Country;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "news_articles_entity")
public class NewsArticleEntity extends BaseEntity{
   @Id // primary key
    //@UuidGenerator tells Hibernate to auto-generate a UUID value for this field.
    //Defaults to UUID v4 (random-based), but you can configure it.
    // Eg: @UuidGenerator(style = UuidGenerator.Style.TIME)
   @UuidGenerator 
   @Column(name = "article_id", updatable = false, nullable = false)
   private UUID id;

   @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = NewsSourceEntity.class)
   @JoinColumn(name = "article_source_id", referencedColumnName = "id", nullable = false)
   private NewsSourceEntity newsSource;

   @Column(nullable = false)
   private String articleAuthor;

   @Column(nullable = false)
   private String articleTitle;

   @Column(nullable = false)
   private String articleDescription;

    @Column(nullable = false)
   private String articleUrl;

   @Column
   private String imageUrl;

   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
   @Column(nullable = false)
   private ZonedDateTime publishedAt;

   @Lob // large object model - blob of text
   @Column(nullable = false, columnDefinition = "LONGTEXT") // or LONGTEXT for larger content
   private String articleContent;

   @Column()
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Category articleCategory;

   @Column()
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Country articleCountry;

   @Column()
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Country articleCity;

   @Lob
   @Column(columnDefinition = "LONGTEXT")
   private String articleSummary;

}
