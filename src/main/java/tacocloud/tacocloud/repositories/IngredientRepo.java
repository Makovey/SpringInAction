package tacocloud.tacocloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tacocloud.tacocloud.entity.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, String> {

}
