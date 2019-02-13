package com.sirius.closeup.normalization.model;

import javax.persistence.*;

@Entity
public class SubRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Region id_provincia;

    public SubRegion() {
    }

    public SubRegion(String name, Region id_provincia) {
        this.name = name;
        this.id_provincia = id_provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Region id_provincia) {
        this.id_provincia = id_provincia;
    }
}
