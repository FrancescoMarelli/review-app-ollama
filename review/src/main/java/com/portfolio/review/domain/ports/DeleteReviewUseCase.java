package com.portfolio.review.domain.ports;

import java.util.UUID;

public interface DeleteReviewUseCase {
    void deleteById(UUID reviewId);
}
