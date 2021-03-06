package com.sirius.normalization.model;

import javax.persistence.*;

@Entity
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    private Cpa cpa;
    @ManyToOne
    private Cp cp;
    @ManyToOne
    private SubRegion paraje;

    public Locality() {
    }

    public Locality(String nombre, Cpa cpa, Cp cp, SubRegion paraje) {
        this.nombre = nombre;
        this.cpa = cpa;
        this.cp = cp;
        this.paraje = paraje;
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

    public Cpa getCpa() {
        return cpa;
    }

    public void setCpa(Cpa cpa) {
        this.cpa = cpa;
    }

    public SubRegion getParaje() {
        return paraje;
    }

    public void setParaje(SubRegion paraje) {
        this.paraje = paraje;
    }

    public Cp getCp() {
        return cp;
    }

    public void setCp(Cp cp) {
        this.cp = cp;
    }
}
