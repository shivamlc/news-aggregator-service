package com.sgtech.news_aggregator_service.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@MappedSuperclass // superclass for entities that will have common fields
// This class will not be mapped to a table directly, but its fields will be inherited by
// subclasses that are mapped to tables.
// It allows us to define common fields like createdAt, updatedAt, createdBy, updatedBy
// which can be reused across multiple entities.
// This helps in reducing code duplication and maintaining consistency across entities.
// Entities that extend this class will automatically have these fields.
public class BaseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Column(name = "record_created_at", updatable = false, nullable = false) // won't get updated after creation
    private ZonedDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Column(name = "record_updated_at", insertable = false) // does not get populated when record is created first time
    private ZonedDateTime updatedAt;

    @Column(name = "record_created_by", updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "record_updated_by", insertable = false)
    private String updatedBy;
    
}
