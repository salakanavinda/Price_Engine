package com.example.price.engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.io.Serializable;

import static com.example.price.engine.config.Constants.StockConstants.*;

/**
 * Stock.
 *
 * @author Salaka, 5/26/2021 11:32 AM
 */
@Entity
@Table(name = TABLE_NAME)
public class Stock implements Serializable {

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = PRODUCT_ID,nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Product product;

    @Column(name = CARTON_QTY)
    private long cartonQty;

    @Column(name = UNIT_QTY)
    private long unitQty;

    public Long getId() {
        return id;
    }

    public Stock setId(Long id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Stock setProduct(Product product) {
        this.product = product;
        return this;
    }

    public long getCartonQty() {
        return cartonQty;
    }

    public Stock setCartonQty(long cartonQty) {
        this.cartonQty = cartonQty;
        return this;
    }

    public long getUnitQty() {
        return unitQty;
    }

    public Stock setUnitQty(long unitQty) {
        this.unitQty = unitQty;
        return this;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", product=" + product +
                ", cartonQty=" + cartonQty +
                ", unitQty=" + unitQty +
                '}';
    }
}
