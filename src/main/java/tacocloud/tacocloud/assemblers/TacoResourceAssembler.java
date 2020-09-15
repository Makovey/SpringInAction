package tacocloud.tacocloud.assemblers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import tacocloud.tacocloud.dto.TacoResource;
import tacocloud.tacocloud.entity.Taco;

public class TacoResourceAssembler implements RepresentationModelAssembler<Taco, TacoResource> {


    @Override
    public TacoResource toModel(Taco entity) {
        return new TacoResource(entity);
    }

    @Override
    public CollectionModel<TacoResource> toCollectionModel(Iterable<? extends Taco> entities) {
        return createResourceWithId(entities.getId(), entities);
    }
}
