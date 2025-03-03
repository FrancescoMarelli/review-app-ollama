package com.portfolio.review.domain.ports;

import com.portfolio.review.domain.model.Review;

public interface CreateReviewUseCase {
    Review create(Review review);
}
