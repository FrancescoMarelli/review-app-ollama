package com.portfolio.review.infrastructure.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@Data
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "points")
    private Integer points;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status")
    private String status;
}
