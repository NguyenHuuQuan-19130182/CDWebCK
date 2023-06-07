package com.erp.backend.entities;


import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id",length = 20,nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false, //
            foreignKey = @ForeignKey(name = "FK"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
    @Column(name = "name",length = 255,nullable = false)
    private String name;;
    @Column(name = "price",nullable = false)
    @NumberFormat( style = NumberFormat.Style.CURRENCY)
    private double price;
    @Column(name = "sell_price",nullable = false)
    @NumberFormat( style = NumberFormat.Style.CURRENCY)
    private double sellPrice;
    @Column(name = "img",nullable = false)
    private String img;
    @Column(name = "quantity ",nullable = false)
    private Integer quantity;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> listComment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }


    public double getSellPrice() {
        return sellPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Review> getListComment() {
        return listComment;
    }

    public void setListComment(List<Review> listComment) {
        this.listComment = listComment;
    }


}
