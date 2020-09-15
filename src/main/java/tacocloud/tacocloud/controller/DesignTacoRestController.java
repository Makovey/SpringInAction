package tacocloud.tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacocloud.tacocloud.entity.Taco;
import tacocloud.tacocloud.repositories.TacoRepo;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoRestController {

    private TacoRepo tacoRepo;
//    EntityLinks entityLinks;

    @Autowired
    public DesignTacoRestController(/*EntityLinks entityLinks,*/ TacoRepo tacoRepo) {
//        this.entityLinks = entityLinks;
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public CollectionModel<EntityModel<Taco>> recentTacos() {
        PageRequest page = PageRequest.of(0, 1, Sort.by("createdAt").descending());

        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<EntityModel<Taco>> recentResources = CollectionModel.wrap(tacos);

        recentResources.add(
                WebMvcLinkBuilder
                        .linkTo(methodOn(DesignTacoRestController.class).recentTacos())
                        .withRel("recent")
        );

        return recentResources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}
