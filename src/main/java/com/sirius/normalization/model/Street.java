package com.sirius.normalization.model;

import javax.persistence.*;

@Entity
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_completo;
    private String nombre_abreviado;
    @ManyToOne
    private Locality id_localidad;

    public Street() {
    }

    public Street(String nombre_completo, String nombre_abreviado, Locality id_localidad) {
        this.nombre_completo = nombre_completo;
        this.nombre_abreviado = nombre_abreviado;
        this.id_localidad = id_localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNombre_abreviado() {
        return nombre_abreviado;
    }

    public void setNombre_abreviado(String nombre_abreviado) {
        this.nombre_abreviado = nombre_abreviado;
    }

    public Locality getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Locality id_localidad) {
        this.id_localidad = id_localidad;
    }
}
