package com.brewedbros.app.entities;

import javax.persistence.*;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id",updatable = false, nullable = false)
    private Long id;
    String gob;


}
