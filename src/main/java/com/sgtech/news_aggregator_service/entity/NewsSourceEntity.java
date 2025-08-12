package com.sgtech.news_aggregator_service.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "news_sources")
public class NewsSourceEntity {

   @Id // primary key
    //@UuidGenerator tells Hibernate to auto-generate a UUID value for this field.
    //Defaults to UUID v4 (random-based), but you can configure it.
    // Eg: @UuidGenerator(style = UuidGenerator.Style.TIME)
   @UuidGenerator 
   @Column(name = "source_id", updatable = false, nullable = false)
   private UUID id;

   @Column(name = "source_name", nullable = false)
   private String name;

   @Column(name = "external_id", unique = true, nullable = false)
   private String externalId;

   @Column(name = "external_description")
   private String description;

   @Column(name = "public_url")
   private String url;



}
