package com.sirius.normalization.model;

import javax.persistence.*;

@Entity
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCompleto;
    private String nombreAbreviado;
    @ManyToOne
    private Locality localidad;

    public Street() {
    }

    public Street(String nombreCompleto, String nombreAbreviado, Locality localidad) {
        this.nombreCompleto = nombreCompleto;
        this.nombreAbreviado = nombreAbreviado;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreAbreviado() {
        return nombreAbreviado;
    }

    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }

    public Locality getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Locality localidad) {
        this.localidad = localidad;
    }
}
