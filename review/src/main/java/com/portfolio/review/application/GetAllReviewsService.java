package com.portfolio.review.application;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.model.filter.ReviewFilter;
import com.portfolio.review.domain.ports.GetAllReviewsUseCase;
import com.portfolio.review.domain.ports.ReviewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllReviewsService implements GetAllReviewsUseCase {

    final private ReviewPort port;

    @Override
    public Page<Review> getAll(ReviewFilter reviewFilter, Pageable pageable) {
        return port.getAllReviews(reviewFilter, pageable);
    }
}
