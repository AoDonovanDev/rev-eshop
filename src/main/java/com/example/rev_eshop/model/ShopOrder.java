package com.example.rev_eshop.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ShopOrder")
public class ShopOrder {
    
    @Column(name="orderId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer order;

    @Column(name="buyerId")
    Integer buyerId;

    @Column(name="sellerId")
    Integer sellerId;

    @Column(name="total")
    Integer total;

    @ManyToMany
    @JoinTable(name="OrderProduct",
    joinColumns=@JoinColumn(name="orderId", referencedColumnName="orderId"),
    inverseJoinColumns=@JoinColumn(name="productId", referencedColumnName="productId"))
    List<Product> products;


    public ShopOrder(){

    }


    public Integer getOrder() {
        return order;
    }


    public void setOrder(Integer order) {
        this.order = order;
    }


    public Integer getBuyerId() {
        return buyerId;
    }


    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }


    public Integer getSellerId() {
        return sellerId;
    }


    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }


    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
