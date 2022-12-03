package com.kucher.la56.service.impl;


import com.kucher.la56.domain.User;
import com.kucher.la56.exception.UserNotFoundExeption;
import com.kucher.la56.repository.UserRepository;
import com.kucher.la56.service.UserService;
import com.kucher.la56.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kucher.la56.domain.Zone;
import com.kucher.la56.exception.ZoneNotFoundExeption;
import com.kucher.la56.service.ZoneService;
import com.kucher.la56.repository.ZoneRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {


    @Autowired
    private final ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<Zone> findAll() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone findById(Integer idzone) {
        return zoneRepository.findById(idzone)
                .orElseThrow(() -> new ZoneNotFoundExeption(idzone));
    }

    @Override
    public Zone create(Zone zone) {
        zoneRepository.save(zone);
        return zone;
    }

    @Override
    @Transactional
    public void update(Integer idzone, Zone uZone) {
        Zone zone = zoneRepository.findById(idzone)
                .orElseThrow(() -> new ZoneNotFoundExeption(idzone));
        zone.setLvl(uZone.getLvl());
        zoneRepository.save(zone);
    }

    @Override
    public void delete(Integer integer) {

    }


}
