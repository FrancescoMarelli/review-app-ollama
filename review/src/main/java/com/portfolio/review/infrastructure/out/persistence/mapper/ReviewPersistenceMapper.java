package com.portfolio.review.infrastructure.out.persistence.mapper;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.infrastructure.out.persistence.entity.ReviewEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ReviewPersistenceMapper {

    Review toDomain(ReviewEntity entity);

    ReviewEntity toEntity(Review review);

    Review toDomain(Optional<ReviewEntity> entity);
}
