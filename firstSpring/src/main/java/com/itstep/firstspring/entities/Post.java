package com.itstep.firstspring.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Post {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;*/
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id = UUID.randomUUID();
    @Column(unique = true, nullable = false, length = 70)
    private String title;
    private String body;
}
