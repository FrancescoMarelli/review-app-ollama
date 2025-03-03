package com.portfolio.review.domain.ports;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.model.filter.ReviewFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllReviewsUseCase {
    Page<Review> getAll(ReviewFilter reviewFilter, Pageable pageable);
}
