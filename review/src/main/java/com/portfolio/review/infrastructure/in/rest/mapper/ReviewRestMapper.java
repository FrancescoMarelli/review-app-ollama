package com.portfolio.review.infrastructure.in.rest.mapper;

import com.portfolio.review.domain.model.Review;
import com.portfolio.review.infrastructure.in.rest.dto.CreateReviewDto;
import com.portfolio.review.infrastructure.in.rest.dto.ReviewIdDto;
import com.portfolio.review.infrastructure.in.rest.dto.ReviewResponseDto;
import com.portfolio.review.infrastructure.in.rest.dto.UpdateReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewRestMapper {
    ReviewRestMapper INSTANCE = Mappers.getMapper(ReviewRestMapper.class);

    Review toDomain(CreateReviewDto createReviewDto);

    Review toDomain(UpdateReviewDto updateReviewDto);

    ReviewIdDto toIdDto(Review review);

    ReviewResponseDto toResponse(Review review);

    List<ReviewResponseDto> toResponseList(List<Review> reviews);

    default Page<ReviewResponseDto> toResponse(Page<Review> reviews) {
        List<ReviewResponseDto> reviewResponseDtos = toResponseList(reviews.getContent());
        return new PageImpl<>(reviewResponseDtos, reviews.getPageable(), reviews.getTotalElements());
    }

}
