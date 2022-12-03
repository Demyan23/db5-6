package com.kucher.la56.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.kucher.la56.controller.SensorController;
import com.kucher.la56.domain.Sensor;
import com.kucher.la56.dto.SensorDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component

public class SensorDtoAssembler implements RepresentationModelAssembler<Sensor, SensorDto>{

    @Override
    public SensorDto toModel(Sensor entity) {
        SensorDto sensorDto = SensorDto.builder()
                .idsensor(entity.getIdsensor())
                .alertInfo(entity.getAlertInfo())
                .info(entity.getInfo())
                .clas(entity.getClazz())
                .alertSettngs(entity.getAlertSettings())
                .build();

        Link selfLink = linkTo(methodOn(SensorController.class).findById(sensorDto.getIdsensor())).withSelfRel();
        sensorDto.add(selfLink);
        return sensorDto;
    }

    @Override
    public CollectionModel toCollectionModel(Iterable<? extends Sensor> entities) {
        CollectionModel<SensorDto> sensorDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SensorController.class).getAllObjects()).withSelfRel();
        sensorDtos.add(selfLink);
        return sensorDtos;
    }



}
