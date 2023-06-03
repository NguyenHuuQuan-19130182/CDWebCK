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
@Table(name = "discountcode")
@SQLDelete(sql = "UPDATE discountcode SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class DiscountCode extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "discountcode_name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_payment",nullable = false)
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "update_payment",nullable = false)
    private Date updateDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
