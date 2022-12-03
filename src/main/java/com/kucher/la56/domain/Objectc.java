package com.kucher.la56.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "object", schema = "db5", catalog = "")
public class Objectc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idobject")
    private Integer idobject;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "adress")
    private String adress;
    @OneToOne
    @JoinColumn(name = "idobject", referencedColumnName = "iduser", nullable = false)
    private User users;

    public Integer getIdobject() {
        return idobject;
    }

    public void setIdobject(Integer idobject) {
        this.idobject = idobject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objectc objectc = (Objectc) o;
        return Objects.equals(idobject, objectc.idobject) && Objects.equals(name, objectc.name) && Objects.equals(adress, objectc.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idobject, name, adress);
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

}
