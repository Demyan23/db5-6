package com.kucher.la56.repository;

import com.kucher.la56.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer>{

    @Procedure("add_zone")
    void addZone(String zoneLvl);

    @Procedure("add_10_zones")
    void addTenZones(String zoneLvl);

}
