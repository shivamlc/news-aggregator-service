package com.sgtech.news_aggregator_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sgtech.news_aggregator_service.dto.NewsSourceDto;
import com.sgtech.news_aggregator_service.service.NewsSourceService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/news-sources/")
public class NewsSourceController {

    private final NewsSourceService newsSourceService; // replace with interface

    public NewsSourceController(NewsSourceService newsSourceService) {
        this.newsSourceService = newsSourceService;
    }

    @PostMapping("save")
    public String postMethodName(@Valid @RequestBody NewsSourceDto newsSource,
            @RequestHeader("request-source") String requestSource) {
        newsSourceService.addNewsSource(newsSource, requestSource);
        return "News source added successfully";
    }

}
//TODO:
// 1. Add validation annotations to NewsSourceDto fields.
// 2. Implement error handling for the service methods using @ControllerAdvice.
// 3. Consider using a logging framework to log the request and response details.
// 4. Add unit tests for the controller methods to ensure they work as expected.
// 5. Ensure that the request-source header is mandatory and handle cases where it is missing
// 6. Add request response dto
// 7. Add Swagger documentation for the API endpoints
// 8. Implement caching for frequently accessed news sources to improve performance
// 9. Consider adding pagination support for the news sources list if applicable
// 10. Aspect logging for method entry and exit points