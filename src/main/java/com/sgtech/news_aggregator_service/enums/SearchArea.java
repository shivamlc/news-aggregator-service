package com.sgtech.news_aggregator_service.enums;

public enum SearchArea {
    title("title"),
    description("description"),
    content("content");

    private final String value;

    SearchArea(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
