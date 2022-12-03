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
@Relation(itemRelation = "object", collectionRelation = "objects")

public class ObjectcDto extends RepresentationModel<ObjectcDto>{

    private Integer idobject;
    private String name;
    private String adrres;

}
