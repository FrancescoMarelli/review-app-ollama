package com.portfolio.review.application;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.ports.ReviewPort;
import com.portfolio.review.domain.ports.UpdateReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateReviewService implements UpdateReviewUseCase {
    final private ReviewPort port;

    @Override
    public Review updateById(UUID reviewId, Review review) {
        return port.updateReviewById(reviewId, review);
    }
}
