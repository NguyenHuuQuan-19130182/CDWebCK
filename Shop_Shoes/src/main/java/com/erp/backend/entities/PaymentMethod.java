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
@Table(name = "payment")
@EqualsAndHashCode(callSuper = true)
public class PaymentMethod extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long id;
    @Column(name = "payment_name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

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


}
