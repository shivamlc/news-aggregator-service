package com.sgtech.news_aggregator_service.enums;

public enum SortBy {
    relevancy("relevancy"),
    popularity("popularity"),
    publishedAt("publishedAt");

    private final String value;

    SortBy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
