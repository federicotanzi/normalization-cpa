package com.sirius.closeup.normalization.model;

import javax.persistence.*;

@Entity
public class SubRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    private Region id_provincia;

    public SubRegion() {
    }

    public SubRegion(String nombre, Region id_provincia) {
        this.nombre = nombre;
        this.id_provincia = id_provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Region getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Region id_provincia) {
        this.id_provincia = id_provincia;
    }
}
