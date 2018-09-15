package com.brewedbros.app.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {
    @Id
    private String id;
    private String ticketName;
    private String ticketType;
    private Float originalPrice;
    private Float discountedPrice;
    private Float discountPercentage;
    private String voucherId;
}
