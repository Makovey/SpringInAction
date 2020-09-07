package tacocloud.tacocloud.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Date createdAt;

    @NotNull
    @Size(min = 3, message = "Name must beat least 3 character long")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @NotNull(message = "You must choose some ingredient")
    @Size(min = 2, message = "You must choose at least 2 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
