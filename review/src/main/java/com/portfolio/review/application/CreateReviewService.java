package com.portfolio.review.application;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.ports.CreateReviewUseCase;
import com.portfolio.review.domain.ports.ReviewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateReviewService implements CreateReviewUseCase {

    private final ReviewPort port;

    @Override
    public Review create(Review review) {
        return port.save(review);
    }

}
