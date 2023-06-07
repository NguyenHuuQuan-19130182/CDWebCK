package com.erp.backend.entities;

import javax.persistence.*;

import com.erp.backend.entities.base.AuditableBase;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@EqualsAndHashCode(callSuper = true)
public class Category extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category", length = 20, nullable = false)
    private long id_category;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "img", length = 255)
    private String img;
    @Column(name = "parent_id",length = 20, nullable = false)
    private int parent_id;


    public long getId_category() {
        return id_category;
    }

    public void setId_category(long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
}
