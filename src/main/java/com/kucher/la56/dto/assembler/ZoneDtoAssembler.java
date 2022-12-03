package com.kucher.la56.dto.assembler;
import com.kucher.la56.controller.UserController;
import com.kucher.la56.domain.User;
import com.kucher.la56.domain.Zone;
import com.kucher.la56.dto.UserDto;
import com.kucher.la56.dto.ZoneDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.kucher.la56.controller.ZoneController;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ZoneDtoAssembler implements RepresentationModelAssembler<Zone, ZoneDto>{

    @Override
    public ZoneDto toModel(Zone entity) {
        ZoneDto zoneDto = ZoneDto.builder()
                .idzone(entity.getIdzone())
                .lvl(entity.getLvl())
                .build();

        Link selfLink = linkTo(methodOn(ZoneController.class).findById(zoneDto.getIdzone())).withSelfRel();
        zoneDto.add(selfLink);
        return zoneDto;
    }

    @Override
    public CollectionModel toCollectionModel(Iterable<? extends Zone> entities) {
        CollectionModel<ZoneDto> zoneDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ZoneController.class).getAllObjects()).withSelfRel();
        zoneDtos.add(selfLink);
        return zoneDtos;
    }

    public CollectionModel<ZoneDto> toCollectionModel(Iterable<? extends Zone> entities, Link link) {
        CollectionModel<ZoneDto> zoneDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        zoneDtos.add(link);
        return zoneDtos;
    }
}
