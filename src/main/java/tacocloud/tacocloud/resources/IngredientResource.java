package tacocloud.tacocloud.resources;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import tacocloud.tacocloud.entity.Ingredient;
import tacocloud.tacocloud.entity.Ingredient.Type;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private final String name;

    @Getter
    private final Type type;

    public IngredientResource(Ingredient ingredient){
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
