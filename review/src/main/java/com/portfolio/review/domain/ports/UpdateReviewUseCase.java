package com.portfolio.review.domain.ports;

import com.portfolio.review.domain.model.Review;

import java.util.UUID;

public interface UpdateReviewUseCase {
    Review updateById(UUID reviewId, Review review);
}
