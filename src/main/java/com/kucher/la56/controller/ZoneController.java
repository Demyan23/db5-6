package com.kucher.la56.controller;

import com.kucher.la56.domain.Zone;
import com.kucher.la56.dto.ZoneDto;
import com.kucher.la56.dto.assembler.ZoneDtoAssembler;
import com.kucher.la56.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/zone")
public class ZoneController {

    private final ZoneService zoneService;
    private final ZoneDtoAssembler zoneDtoAssembler;


    @Autowired
    public ZoneController(ZoneService zoneService, ZoneDtoAssembler zoneDtoAssembler) {
        this.zoneService = zoneService;
        this.zoneDtoAssembler = zoneDtoAssembler;
    }

    @GetMapping(value = "/{zoneid}")
    public ResponseEntity<ZoneDto> findById(@PathVariable Integer zoneid) {
        Zone zone = zoneService.findById(zoneid);
        ZoneDto zoneDto = zoneDtoAssembler.toModel(zone);
        return new ResponseEntity<>(zoneDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ZoneDto>> getAllObjects() {
        List<Zone> zones = zoneService.findAll();
        CollectionModel<ZoneDto> zoneDtos = zoneDtoAssembler.toCollectionModel(zones);
        return new ResponseEntity<>(zoneDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ZoneDto> add(@RequestBody Zone zone) {
        Zone newZone = zoneService.create(zone);
        ZoneDto zoneDto = zoneDtoAssembler.toModel(newZone);
        return new ResponseEntity<>(zoneDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{zoneid}")
    public ResponseEntity<?> update(@RequestBody Zone uZone, @PathVariable Integer zoneid) {
        zoneService.update(zoneid, uZone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{zoneid}")
    public ResponseEntity<?> delete(@PathVariable Integer zoneid) {
        zoneService.delete(zoneid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
