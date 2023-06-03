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
@Table(name = "orders")
@SQLDelete(sql = "UPDATE orders SET isDeleted = true WHERE ID = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Order extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 50)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id", nullable = false, //
            foreignKey = @ForeignKey(name = "Ship_DETAIL_ORD_FK"))
    private ShippingInfo shippingInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, //
            foreignKey = @ForeignKey(name = "Acc_ORD_FK"))
    private User account;
    @OneToOne
    @JoinColumn(name = "payment_id",nullable = false)
    private PaymentMethod paymentMethod;
    @Column(name = "state", length = 128)
    private String state;
    @Column(name = "note", length = 128)
    private String note;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
