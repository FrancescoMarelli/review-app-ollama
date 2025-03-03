package com.portfolio.review.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Review {
    private UUID id;
    private String userId;
    private Integer points;
    private LocalDateTime date;
    private String status;
}
