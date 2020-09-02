package tacocloud.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacocloud.tacocloud.domain.Ingredient;
import tacocloud.tacocloud.domain.Ingredient.Type;
import tacocloud.tacocloud.domain.Taco;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Deced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";

    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors){
        //TODO ПРОПУСКАЕТ ЕСЛИ НЕ ВЫБИРАТЬ ИНГРЕДИЕНТЫ
        //TODO ПАДАЕТ, 500 ЕСЛИ НЕ УКАЗАТЬ ИМЯ
        //TODO ОСТАВИТЬ СООБЩЕНИЕ ОБ ОШИБКЕ
        if(errors.hasErrors()){
            return "design";
        }

        //TODO save our taco & create class Design
        log.info("Processing design: " + taco);
        return "redirect:/orders/current";
    }
}
