package com.portfolio.review.infrastructure.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
@Builder
public class ReviewResponseDto {
    private String userId;
    private Integer points;
    private Date date;
    private String status;
}
