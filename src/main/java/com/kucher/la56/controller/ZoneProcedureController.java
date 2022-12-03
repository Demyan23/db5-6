package com.kucher.la56.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kucher.la56.dto.assembler.ZoneDtoAssembler;
import com.kucher.la56.service.ZoneProcedureService;

@RestController
@RequestMapping(value = "/api/zones")
public class ZoneProcedureController {

    @Autowired
    private ZoneProcedureService zoneProcedureService;
    @Autowired
    private ZoneDtoAssembler zoneDtoAssembler;

    @PostMapping(value = "package")
    public ResponseEntity<?> addTenZones(@RequestBody String zoneLvl) {
        zoneProcedureService.addTenZones(zoneLvl);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addZone(@RequestBody String zoneLvl) {
        zoneProcedureService.addZone(zoneLvl);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
