package com.kefas.TaskBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String parent;
}
