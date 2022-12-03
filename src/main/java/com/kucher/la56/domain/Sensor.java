package com.kucher.la56.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sensor", schema = "db5", catalog = "")
public class Sensor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsensor")
    private Integer idsensor;
    @Basic
    @Column(name = "class")
    private String clazz;
    @Basic
    @Column(name = "info")
    private String info;
    @Basic
    @Column(name = "alertInfo")
    private String alertInfo;
    @Basic
    @Column(name = "alertSettings")
    private String alertSettings;

    public Integer getIdsensor() {
        return idsensor;
    }

    public void setIdsensor(Integer idsensor) {
        this.idsensor = idsensor;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAlertInfo() {
        return alertInfo;
    }

    public void setAlertInfo(String alertInfo) {
        this.alertInfo = alertInfo;
    }

    public String getAlertSettings() {
        return alertSettings;
    }

    public void setAlertSettings(String alertSettings) {
        this.alertSettings = alertSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(idsensor, sensor.idsensor) && Objects.equals(clazz, sensor.clazz) && Objects.equals(info, sensor.info) && Objects.equals(alertInfo, sensor.alertInfo) && Objects.equals(alertSettings, sensor.alertSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idsensor, clazz, info, alertInfo, alertSettings);
    }

}
