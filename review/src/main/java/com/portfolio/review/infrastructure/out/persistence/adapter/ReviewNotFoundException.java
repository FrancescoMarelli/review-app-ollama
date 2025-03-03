package com.portfolio.review.infrastructure.out.persistence.adapter;

import java.util.UUID;

public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(UUID reviewId) {
        super("Review not found with ID: " + reviewId);
    }
}

