package com.kucher.la56.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.kucher.la56.controller.ObjectcController;
import com.kucher.la56.domain.Objectc;
import com.kucher.la56.dto.ObjectcDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ObjectDtoAssembler implements RepresentationModelAssembler<Objectc, ObjectcDto>{
    @Override
    public  ObjectcDto toModel(Objectc entity) {
        ObjectcDto objectDto = ObjectcDto.builder()
                .idobject(entity.getIdobject())
                .name(entity.getName())
                .adrres(entity.getAdress())
                .build();

        Link selfLink = linkTo(methodOn(ObjectcController.class).findById(objectDto.getIdobject())).withSelfRel();
        objectDto.add(selfLink);
        return objectDto;
    }

    @Override
    public CollectionModel toCollectionModel(Iterable<? extends Objectc> entities) {
        CollectionModel<ObjectcDto> objectcDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ObjectcController.class).getAllObjects()).withSelfRel();
        objectcDtos.add(selfLink);
        return objectcDtos;
    }
    public CollectionModel<ObjectcDto> toCollectionModel(Iterable<? extends Objectc> entities, Link link) {
        CollectionModel<ObjectcDto> objectcDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        objectcDtos.add(link);
        return objectcDtos;
    }

}
