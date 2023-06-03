package com.erp.backend.entities;

import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipping")
@SQLDelete(sql = "UPDATE shipping SET isDeleted = true WHERE shpping_id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class ShippingInfo extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Long id;
    @Column(name = "shipping_email", length = 128, nullable = false)
    private String shippingEmail;
    @Column(name = "shipping_name", length = 255, nullable = false)
    private String shippingName;
    @Column(name = "shipping_phone", length = 128, nullable = false)
    private String shippingPhone;
    @Column(name = "shipping_address", length = 255, nullable = false)
    private String shippingAddress;
    @Column(name = "xa", length = 255, nullable = false)
    private String xa;
    @Column(name = "huyen", length = 255, nullable = false)
    private String huyen;
    @Column(name = "tinh", length = 255, nullable = false)
    private String tinh;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingEmail() {
        return shippingEmail;
    }

    public void setShippingEmail(String shippingEmail) {
        this.shippingEmail = shippingEmail;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

}