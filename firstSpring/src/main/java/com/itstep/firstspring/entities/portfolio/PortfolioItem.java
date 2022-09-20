package com.itstep.firstspring.entities.portfolio;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer price;
    private Integer time;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
