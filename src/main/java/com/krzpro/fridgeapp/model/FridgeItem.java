package com.krzpro.fridgeapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class FridgeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int quantity;
    private LocalDate expiryDate;
    private LocalDate addedDate;

    public FridgeItem() {}

    @Override
    public String toString() {
        return "FridgeItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", addedDate=" + addedDate +
                '}';
    }

    public FridgeItem(Long id, Product product, int quantity, LocalDate expiryDate, LocalDate addedDate) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.addedDate = addedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
