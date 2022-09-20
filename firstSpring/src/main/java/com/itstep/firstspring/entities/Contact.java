package com.itstep.firstspring.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String text;
    @Column(columnDefinition = "TEXT")
    private String message;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at = new Date();
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
