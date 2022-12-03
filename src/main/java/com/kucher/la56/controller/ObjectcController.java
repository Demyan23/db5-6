package com.kucher.la56.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kucher.la56.domain.Objectc;
import com.kucher.la56.dto.ObjectcDto;
import com.kucher.la56.dto.assembler.ObjectDtoAssembler;
import com.kucher.la56.service.ObjectService;

import java.util.List;

@RestController
@RequestMapping("/api/object")
public class ObjectcController {

    private final ObjectService objectService;
    private final ObjectDtoAssembler objectDtoAssembler;


    @Autowired
    public ObjectcController(ObjectService objectService, ObjectDtoAssembler objectDtoAssembler) {
        this.objectService = objectService;
        this.objectDtoAssembler = objectDtoAssembler;
    }

    @GetMapping(value = "/{objectid}")
    public ResponseEntity<ObjectcDto> findById(@PathVariable Integer objectid) {
        Objectc objectc = objectService.findById(objectid);
        ObjectcDto objectcDto = objectDtoAssembler.toModel(objectc);
        return new ResponseEntity<>(objectcDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ObjectcDto>> getAllObjects() {
        List<Objectc> objects = objectService.findAll();
        CollectionModel<ObjectcDto> objectcDtos = objectDtoAssembler.toCollectionModel(objects);
        return new ResponseEntity<>(objectcDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ObjectcDto> add(@RequestBody Objectc objectc) {
        Objectc newObject = objectService.create(objectc);
        ObjectcDto objectcDto = objectDtoAssembler.toModel(newObject);
        return new ResponseEntity<>(objectcDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{objectid}")
    public ResponseEntity<?> update(@RequestBody Objectc uObject, @PathVariable Integer objectid) {
        objectService.update(objectid, uObject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{objectid}")
    public ResponseEntity<?> delete(@PathVariable Integer objectid) {
        objectService.delete(objectid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
