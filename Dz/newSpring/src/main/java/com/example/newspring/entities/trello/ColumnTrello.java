package com.example.newspring.entities.trello;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ColumnTrello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    @OneToMany
    @JoinColumn(name = "column_id")
    private Set<Cell> cells;


    private String name;
    @CreationTimestamp
    private Date created_at;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
