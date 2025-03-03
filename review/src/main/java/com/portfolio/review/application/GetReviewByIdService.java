package com.portfolio.review.application;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.ports.GetReviewByIdUseCase;
import com.portfolio.review.domain.ports.ReviewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetReviewByIdService implements GetReviewByIdUseCase {
    final private ReviewPort port;

    @Override
    public Review retrieveById(UUID reviewId) {
        return port.getReviewById(reviewId);
    }
}
