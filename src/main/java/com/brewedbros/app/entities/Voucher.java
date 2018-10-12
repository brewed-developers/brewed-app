package com.brewedbros.app.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Voucher {

    @Id
    private String id;
    private String name;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String voucherType;
    private String rating;
    private String priority;
    private String city;
    private String area;
    private Long noOfViews;
    private Long noOfLikes;
    private Long noOfBookMarks;
    private Long noOfShares;
    private int ticketCount;
    private String imgURL;
    private String showImage;
    @Column(name = "show_home_page", nullable = false, columnDefinition = "bool default false")
    private boolean showHomePage;
    @Transient
    private List<Section> sections;
    @Transient
    private List<Ticket> tickets = new ArrayList<Ticket>();
    @Transient
    private Location location;
}
