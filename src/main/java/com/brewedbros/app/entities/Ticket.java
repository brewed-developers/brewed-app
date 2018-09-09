package com.brewedbros.app.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String ticketName;
    private String ticketType;
    private Float originalPrice;
    private Float discountedPrice;
    private Float discountPercentage;
    private String voucherId;
}
