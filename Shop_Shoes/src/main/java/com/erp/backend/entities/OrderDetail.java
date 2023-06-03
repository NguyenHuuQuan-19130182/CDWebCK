package com.erp.backend.entities;

import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
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
@SQLDelete(sql = "UPDATE order_Details SET isDeleted = true WHERE ID = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class OrderDetail extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 50, nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PRO_FK"))
    private Size size;
    @Column(name = "Quanity", nullable = false)
    private int quanity;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "total", nullable = false)
    private double total;
    @Column(name = "note", length = 128)
    private String note;

    public OrderDetail(Order order, Size size, int quantity, double price, double setTotal, String note) {
    }

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


    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

}
