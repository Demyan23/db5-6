package com.kucher.la56.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "category", collectionRelation = "categories")

public class UserDto extends RepresentationModel<UserDto>{

    private Integer iduser;
    private Integer lvl;
    private String name;
    private String sirname;
    private Integer age;
    private String email;

}
