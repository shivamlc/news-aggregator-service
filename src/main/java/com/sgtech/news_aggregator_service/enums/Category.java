package com.sgtech.news_aggregator_service.enums;


public enum Category {
    business("business"),
    entertainment("entertainment"),
    general("general"),
    health("health"),
    science("science"),
    sports("sports"),
    technology("technology");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}