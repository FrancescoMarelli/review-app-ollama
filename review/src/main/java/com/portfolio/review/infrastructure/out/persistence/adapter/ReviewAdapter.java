package com.portfolio.review.infrastructure.out.persistence.adapter;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.domain.model.filter.ReviewFilter;
import com.portfolio.review.domain.ports.ReviewPort;
import com.portfolio.review.infrastructure.out.persistence.entity.ReviewEntity;
import com.portfolio.review.infrastructure.out.persistence.mapper.ReviewPersistenceMapper;
import com.portfolio.review.infrastructure.out.persistence.repository.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewAdapter implements ReviewPort {
    private final ReviewJpaRepository repository;
    private final ReviewPersistenceMapper persistenceMapper;

    @Override
    public Review save(Review review) {
        ReviewEntity entity = persistenceMapper.toEntity(review);
        return persistenceMapper.toDomain(repository.save(entity));
    }


    @Override
    public void delete(UUID reviewId) {
        repository.delete(reviewId);
    }

    @Override
    public Page<Review> getAllReviews(ReviewFilter reviewFilter, Pageable pageable) {
        // Obtengo datos paginados de BBDD
        Page<ReviewEntity> reviewEntities = repository.findAll(pageable);

        List<Review> reviews = reviewEntities.getContent()
            .stream()
            .map(persistenceMapper::toDomain)
            .toList();
        return new PageImpl<>(reviews, pageable, reviewEntities.getTotalElements());
    }

    @Override
    public Review getReviewById(UUID reviewId) {
        Optional<ReviewEntity> entity = repository.findById(reviewId.toString());
        return persistenceMapper.toDomain(entity);
    }

    @Override
    public Review updateReviewById(UUID reviewId, Review review) {
        if (!repository.existsById(reviewId.toString())) {
            throw new ReviewNotFoundException(reviewId);
        }
        ReviewEntity entity = persistenceMapper.toEntity(review);
        entity.setId(reviewId.toString());
        return persistenceMapper.toDomain(repository.save(entity));
    }

}
