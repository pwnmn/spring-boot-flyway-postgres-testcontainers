package com.github.pwnmn.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "things")
@Data
public class ThingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "color", nullable = false)
    private String color;
}
