package com.kucher.la56.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "db5", catalog = "")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "iduser")
    private Integer iduser;
    @Basic
    @Column(name = "lvl")
    private Integer lvl;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "sirname")
    private String sirname;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "email")
    private String email;
    @OneToOne(mappedBy = "users")
    private Objectc objects;

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(iduser, user.iduser) && Objects.equals(lvl, user.lvl) && Objects.equals(name, user.name) && Objects.equals(sirname, user.sirname) && Objects.equals(age, user.age) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, lvl, name, sirname, age, email);
    }

    public Objectc getObjects() {
        return objects;
    }

    public void setObjects(Objectc objects) {
        this.objects = objects;
    }
}
