package com.enigma.gold.market.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "mst_product")
public class EntityProduct {
    @Id
    @Column(nullable = false)
    private String product_id;

    @Column(nullable = true)
    private Date created_at;

    @Column(nullable = false)
    private String product_image;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private Integer product_price_buy;

    @Column(nullable = false)
    private Integer product_price_sell;

    @Column(nullable = false)
    private Integer product_status;

    @Column(nullable = true)
    private Date updated_at;


}
