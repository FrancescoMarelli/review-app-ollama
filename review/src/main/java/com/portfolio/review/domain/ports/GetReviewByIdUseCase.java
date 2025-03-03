package com.portfolio.review.domain.ports;

import com.portfolio.review.domain.model.Review;

import java.util.UUID;

public interface GetReviewByIdUseCase {
    Review retrieveById(UUID reviewId);
}
