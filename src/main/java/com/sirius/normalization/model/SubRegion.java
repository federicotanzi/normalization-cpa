package com.sirius.normalization.model;

import javax.persistence.*;

@Entity
public class SubRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    private Region provincia;

    public SubRegion() {
    }

    public SubRegion(String nombre, Region provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
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

    public Region getProvincia() {
        return provincia;
    }

    public void setProvincia(Region provincia) {
        this.provincia = provincia;
    }
}
