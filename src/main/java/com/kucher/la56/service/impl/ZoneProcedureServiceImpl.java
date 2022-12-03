package com.kucher.la56.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kucher.la56.repository.ZoneRepository;
import com.kucher.la56.service.ZoneProcedureService;

@Service
public class ZoneProcedureServiceImpl implements ZoneProcedureService{

    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public void addTenZones(String zoneLvl) {
        zoneRepository.addTenZones(zoneLvl);
    }

    @Override
    public void addZone(String zoneLvl) {

        zoneRepository.addZone(zoneLvl);

    }
}
