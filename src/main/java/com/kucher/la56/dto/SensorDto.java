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

public class SensorDto extends RepresentationModel<ObjectcDto>{

    private Integer idsensor;
    private String clas;
    private String info;
    private String alertInfo;
    private String alertSettngs;

}
