package com.erp.backend.entities;


import com.erp.backend.entities.base.AuditableBase;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
@SQLDelete(sql = "UPDATE cart SET isDeleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@EqualsAndHashCode(callSuper = true)
public class Cart  extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Size size;
    @OneToOne
    private User user;
    private int quantity;


}
