package com.portfolio.review.infrastructure.out.persistence.repository;

import com.portfolio.review.infrastructure.out.persistence.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, String>,
    JpaSpecificationExecutor<ReviewEntity> {
    void delete(UUID reviewId);
}
