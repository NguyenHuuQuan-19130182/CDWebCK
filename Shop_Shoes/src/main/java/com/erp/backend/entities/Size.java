package com.erp.backend.entities;

import com.erp.backend.entities.base.AuditableBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "size")
@EqualsAndHashCode(callSuper = true)
public class Size extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "size_id", length = 20, nullable = false)
    private long sizeId;
    @Column(name = "size_num", nullable = false)
    private int size_num;

    public long getSizeId() {
        return sizeId;
    }

    public int getSize_num() {
        return size_num;
    }

    public void setSizeId(long sizeId) {
        this.sizeId = sizeId;
    }

    public void setSize_num(int size_num) {
        this.size_num = size_num;
    }


}
