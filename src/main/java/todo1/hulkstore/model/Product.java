package todo1.hulkstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    long id;
    String name;
    String description;
    double price;
}
