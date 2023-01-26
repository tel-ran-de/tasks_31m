package de.telran.surf.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    private double price;

    private double oldPrice;

    private boolean isNew;

    private boolean isHot;

    private String picture;

    private String description;

    // optional = false - значит, что связь обязательная
    @ManyToOne(optional = false)
    private Category category;

}
