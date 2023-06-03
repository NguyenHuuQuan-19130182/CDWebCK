package com.erp.backend.entities;

import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
@SQLDelete(sql = "UPDATE reviews SET isDeleted = true WHERE ID = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Review extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 50, nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false, //
            foreignKey = @ForeignKey(name = "Acc_PROD_FK"))
    private User account;
    private int star;
    @Column(name = "cmt", length = 255)
    private String cmt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }


}
