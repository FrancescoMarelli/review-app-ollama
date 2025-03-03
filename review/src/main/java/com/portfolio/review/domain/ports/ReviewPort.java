package com.portfolio.review.domain.ports;


import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.model.filter.ReviewFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ReviewPort {
    Review save(Review review);

    void delete(UUID reviewId);

    Page<Review> getAllReviews(ReviewFilter reviewFilter, Pageable pageable);

    Review getReviewById(UUID reviewId);

    Review updateReviewById(UUID reviewId, Review review);
}
