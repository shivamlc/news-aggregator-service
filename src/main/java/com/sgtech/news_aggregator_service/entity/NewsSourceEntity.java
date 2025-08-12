package com.sgtech.news_aggregator_service.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sgtech.news_aggregator_service.enums.Category;
import com.sgtech.news_aggregator_service.enums.Country;
import com.sgtech.news_aggregator_service.enums.Language;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "news_sources_entity")
public class NewsSourceEntity extends BaseEntity {

   @Id // primary key
    //@UuidGenerator tells Hibernate to auto-generate a UUID value for this field.
    //Defaults to UUID v4 (random-based), but you can configure it.
    // Eg: @UuidGenerator(style = UuidGenerator.Style.TIME)
   @UuidGenerator 
   @Column(name = "source_id", updatable = false, nullable = false)
   private UUID id;

   @Column(name = "source_name", nullable = false)
   private String name;

   @Column(unique = true, nullable = false)
   private String externalId;

   @Column(name = "external_description")
   private String description;

   @Column(name = "public_url")
   private String url;

   @Column(name = "news_category")
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Category category;

   @Column(name = "news_language")
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Language language;

   @Column(name = "source_country")
   @Enumerated(value = jakarta.persistence.EnumType.STRING) // stores enum as string in DB
   private Country country;
}
