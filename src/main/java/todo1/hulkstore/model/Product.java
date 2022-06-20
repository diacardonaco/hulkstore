package todo1.hulkstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String name;
    private String description;
    private double price;
    private double amount;

    //@ManyToOne
    //private Inventory inventory;

}
