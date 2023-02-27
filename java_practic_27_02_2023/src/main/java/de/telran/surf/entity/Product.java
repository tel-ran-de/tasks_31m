package de.telran.surf.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @Min(value = 100, message = "Цена не может быть меньше 100")
    private double price;

    @Max(value = 150)
    private double oldPrice;

    @Column(name = "is_new")
    private boolean newProduct;

    @Column(name = "is_hot")
    private boolean hotProduct;

    private String picture;

    @Column(columnDefinition = "text")
    private String description;

    // optional = false - значит, что связь обязательная
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
