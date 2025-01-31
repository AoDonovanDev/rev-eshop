package com.example.rev_eshop.model;
import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    
    @Column(name="productId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name="productName")
    private String productName;

    @Column(name="price")
    private Double price;

    @Column(name="sellerId")
    private Integer sellerId;


    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
