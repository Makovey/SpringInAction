package tacocloud.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacocloud.tacocloud.entity.Ingredient;
import tacocloud.tacocloud.repositories.IngredientRepo;

@RestController
@RequestMapping(path = "/ingredient", produces = "application/json")
@CrossOrigin("*")
public class IngredientController {

    private final IngredientRepo ingredientRepo;

    @Autowired
    public IngredientController(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredient(){
        return ingredientRepo.findAll();
    }
}
