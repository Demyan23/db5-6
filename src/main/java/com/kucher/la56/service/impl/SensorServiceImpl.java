package com.kucher.la56.service.impl;

import com.kucher.la56.domain.Sensor;
import com.kucher.la56.exception.SensorNotFoundExeption;
import com.kucher.la56.repository.SensorRepository;
import com.kucher.la56.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor findById(Integer idsensor) {
        return sensorRepository.findById(idsensor)
                .orElseThrow(() -> new SensorNotFoundExeption(idsensor));
    }

    @Override
    public Sensor create(Sensor sensor) {
        sensorRepository.save(sensor);
        return sensor;
    }

    @Override
    @Transactional
    public void update(Integer idsensor, Sensor uSensor) {
        Sensor sensor = sensorRepository.findById(idsensor)
                .orElseThrow(() -> new SensorNotFoundExeption(idsensor));
        sensor.setIdsensor(uSensor.getIdsensor());
        sensor.setAlertInfo(uSensor.getAlertInfo());
        sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public void delete(Integer idsensor) {
        Sensor sensor = sensorRepository.findById(idsensor)
                .orElseThrow(() -> new SensorNotFoundExeption(idsensor));
        if (!sensor.getAlertInfo().isEmpty()) throw new SensorNotFoundExeption(idsensor);
        sensorRepository.delete(sensor);
    }

}
