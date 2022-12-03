package com.kucher.la56.repository;


import com.kucher.la56.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer>{
}
