package com.kucher.la56.dto.assembler;

import com.kucher.la56.domain.Objectc;
import com.kucher.la56.dto.ObjectcDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.kucher.la56.controller.UserController;
import com.kucher.la56.domain.User;
import com.kucher.la56.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserDtoAssembler implements RepresentationModelAssembler<User, UserDto>{

    @Override
    public UserDto toModel(User entity) {
        UserDto userDto = UserDto.builder()
                .iduser(entity.getIduser())
                .name(entity.getName())
                .lvl(entity.getLvl())
                .sirname(entity.getSirname())
                .age(entity.getAge())
                .email(entity.getEmail())
                .build();

        Link selfLink = linkTo(methodOn(UserController.class).findById(userDto.getIduser())).withSelfRel();
        userDto.add(selfLink);
        return userDto;
    }

    @Override
    public CollectionModel toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserDto> userDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserController.class).getAllObjects()).withSelfRel();
        userDtos.add(selfLink);
        return userDtos;
    }
    public CollectionModel<UserDto> toCollectionModel(Iterable<? extends User> entities, Link link) {
        CollectionModel<UserDto> userDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        userDtos.add(link);
        return userDtos;
    }

}
