package com.portfolio.review.application;

import com.portfolio.review.domain.ports.DeleteReviewUseCase;
import com.portfolio.review.domain.ports.ReviewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteReviewService implements DeleteReviewUseCase {

    final private ReviewPort port;

    @Override
    @Transactional(readOnly = true)
    public void deleteById(UUID reviewId) {
        port.delete(reviewId);
    }
}
