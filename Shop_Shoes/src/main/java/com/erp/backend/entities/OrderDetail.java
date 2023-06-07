package com.erp.backend.entities;

import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_Details")
@EqualsAndHashCode(callSuper = true)
public class OrderDetail extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 50, nullable = false)
    private long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PRO_FK"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;
    private int size;
    @Column(name = "Quanity", nullable = false)
    private int quantity;
    @Column(name = "total", nullable = false)
    private double total;
    @Column(name = "note", length = 128)
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return getQuantity() * getProduct().getPrice();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
