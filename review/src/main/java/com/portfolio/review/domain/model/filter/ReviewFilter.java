package com.portfolio.review.domain.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class ReviewFilter {

    private String userId;
    private Integer points;
    private LocalDateTime date;
    private String status;
}
