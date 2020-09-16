package tacocloud.tacocloud.assemblers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacocloud.tacocloud.controller.IngredientController;
import tacocloud.tacocloud.resources.IngredientResource;
import tacocloud.tacocloud.entity.Ingredient;

public class IngredientAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }
}
