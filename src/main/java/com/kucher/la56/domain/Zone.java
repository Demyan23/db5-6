package com.kucher.la56.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Zone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idzone")
    private Integer idzone;
    @Basic
    @Column(name = "lvl")
    private String lvl;

    public Integer getIdzone() {
        return idzone;
    }

    public void setIdzone(Integer idzone) {
        this.idzone = idzone;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return Objects.equals(idzone, zone.idzone) && Objects.equals(lvl, zone.lvl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idzone, lvl);
    }
}
