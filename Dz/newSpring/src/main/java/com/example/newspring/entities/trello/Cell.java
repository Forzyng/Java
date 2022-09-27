package com.example.newspring.entities.trello;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "column_id", nullable = false)
    private ColumnTrello column;


    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
    @CreationTimestamp
    private Date created_at;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
