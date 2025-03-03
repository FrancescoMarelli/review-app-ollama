package com.portfolio.review.infrastructure.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ReviewIdDto {
    private String userId;
}
