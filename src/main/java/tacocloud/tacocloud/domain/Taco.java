package tacocloud.tacocloud.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min = 3, message = "Name must beat least 5 character long")
    private String name;
    @Size(min = 2, message = "You must choose at least 2 ingredient")
    private List<String> ingredients;
}
