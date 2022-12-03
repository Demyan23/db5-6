package com.kucher.la56.controller;

import com.kucher.la56.dto.assembler.ObjectDtoAssembler;
import com.kucher.la56.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kucher.la56.domain.Sensor;
import com.kucher.la56.dto.SensorDto;
import com.kucher.la56.dto.assembler.SensorDtoAssembler;
import com.kucher.la56.service.SensorService;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")

public class SensorController {

    private final SensorService sensorService;
    private final SensorDtoAssembler sensorDtoAssembler;


    @Autowired
    public SensorController(SensorService sensorService, SensorDtoAssembler sensorDtoAssembler) {
        this.sensorService = sensorService;
        this.sensorDtoAssembler = sensorDtoAssembler;
    }

    @GetMapping(value = "/{sensorid}")
    public ResponseEntity<SensorDto> findById(@PathVariable Integer sensorid) {
        Sensor sensor = sensorService.findById(sensorid);
        SensorDto sensorDto = sensorDtoAssembler.toModel(sensor);
        return new ResponseEntity<>(sensorDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SensorDto>> getAllObjects() {
        List<Sensor> sensors = sensorService.findAll();
        CollectionModel<SensorDto> sensorDtos = sensorDtoAssembler.toCollectionModel(sensors);
        return new ResponseEntity<>(sensorDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SensorDto> add(@RequestBody Sensor sensor) {
        Sensor newSensor = sensorService.create(sensor);
        SensorDto sensorDto = sensorDtoAssembler.toModel(newSensor);
        return new ResponseEntity<>(sensorDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{sensorid}")
    public ResponseEntity<?> update(@RequestBody Sensor uSensor, @PathVariable Integer sensorid) {
        sensorService.update(sensorid, uSensor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{sensorid}")
    public ResponseEntity<?> delete(@PathVariable Integer sensorid) {
        sensorService.delete(sensorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
