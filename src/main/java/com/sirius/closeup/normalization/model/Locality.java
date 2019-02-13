package com.sirius.closeup.normalization.model;

import javax.persistence.*;

@Entity
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    private Cpa id_cpa;
    @ManyToOne
    private SubRegion id_paraje;

    public Locality() {
    }

    public Locality(String nombre, Cpa id_cpa, SubRegion id_paraje) {
        this.nombre = nombre;
        this.id_cpa = id_cpa;
        this.id_paraje = id_paraje;
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

    public Cpa getId_cpa() {
        return id_cpa;
    }

    public void setId_cpa(Cpa id_cpa) {
        this.id_cpa = id_cpa;
    }

    public SubRegion getId_paraje() {
        return id_paraje;
    }

    public void setId_paraje(SubRegion id_paraje) {
        this.id_paraje = id_paraje;
    }
}
