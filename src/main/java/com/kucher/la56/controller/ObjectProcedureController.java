package com.kucher.la56.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kucher.la56.dto.assembler.ObjectDtoAssembler;
import com.kucher.la56.service.ObjectProcedureService;

@RestController
@RequestMapping(value = "/api/objects")
public class ObjectProcedureController {
    @Autowired
    private ObjectProcedureService objectProcedureService;
    @Autowired
    private ObjectDtoAssembler objectDtoAssembler;
    @PostMapping(value = "addBaseObject/{objectId}/{userId}")
    public ResponseEntity<?> addBaseAirport(@PathVariable int objectId, @PathVariable int userId) {
        objectProcedureService.addBaseObject(objectId, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
