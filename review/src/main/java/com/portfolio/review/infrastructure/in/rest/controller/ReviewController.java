package com.portfolio.review.infrastructure.in.rest.controller;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.model.filter.ReviewFilter;
import com.portfolio.review.domain.ports.CreateReviewUseCase;
import com.portfolio.review.domain.ports.DeleteReviewUseCase;
import com.portfolio.review.domain.ports.GetAllReviewsUseCase;
import com.portfolio.review.domain.ports.GetReviewByIdUseCase;
import com.portfolio.review.domain.ports.UpdateReviewUseCase;
import com.portfolio.review.infrastructure.in.rest.dto.CreateReviewDto;
import com.portfolio.review.infrastructure.in.rest.dto.ReviewIdDto;
import com.portfolio.review.infrastructure.in.rest.dto.ReviewResponseDto;
import com.portfolio.review.infrastructure.in.rest.dto.UpdateReviewDto;
import com.portfolio.review.infrastructure.in.rest.mapper.ReviewRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ReviewController {
    private final CreateReviewUseCase createReviewUseCase;
    private final DeleteReviewUseCase deleteReviewUseCase;
    private final GetReviewByIdUseCase getReviewByIdUseCase;
    private final GetAllReviewsUseCase getAllReviewsUseCase;
    private final UpdateReviewUseCase updateReviewUseCase;

    private final ReviewRestMapper reviewRestMapper;

    @PostMapping("/review}")
    ResponseEntity<ReviewIdDto> postReview(@RequestBody CreateReviewDto createReviewDto) {
        return ResponseEntity.ok().body(reviewRestMapper.toIdDto(createReviewUseCase.create(reviewRestMapper.toDomain(createReviewDto))));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID reviewId) {
        deleteReviewUseCase.deleteById(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reviews")
    public ResponseEntity<Page<ReviewResponseDto>> getAllReviews(
        @RequestParam(required = false) String userId,
        @RequestParam(required = false) Integer points,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
        @RequestParam(required = false) String status,
        Pageable pageable) {

        ReviewFilter reviewFilter = new ReviewFilter(userId, points, date, status);
        Page<Review> reviews = getAllReviewsUseCase.getAll(reviewFilter, pageable);

        return ResponseEntity.ok(reviewRestMapper.toResponse(reviews));
    }

    @GetMapping("/reviews/review/{reviewId}")
    public ResponseEntity<ReviewResponseDto> getReviewById(@RequestParam UUID reviewId) {
        Review review = getReviewByIdUseCase.retrieveById(reviewId);
        return ResponseEntity.ok(reviewRestMapper.toResponse(review));
    }

    @PutMapping("/reviews/review/{reviewId}")
    public ResponseEntity<ReviewResponseDto> updateById(@PathVariable UUID reviewId,
                                                        @RequestBody UpdateReviewDto updateReviewDto) {
        Review updatedReview = updateReviewUseCase.updateById(reviewId, reviewRestMapper.toDomain(updateReviewDto));
        return ResponseEntity.ok(reviewRestMapper.toResponse(updatedReview));
    }


}
