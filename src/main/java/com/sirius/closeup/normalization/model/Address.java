package com.sirius.closeup.normalization.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Street id_calle;
    private Long desde;
    private Long hasta;
    @ManyToOne
    private Cpa id_cpa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Street getId_calle() {
        return id_calle;
    }

    public void setId_calle(Street id_calle) {
        this.id_calle = id_calle;
    }

    public Long getDesde() {
        return desde;
    }

    public void setDesde(Long desde) {
        this.desde = desde;
    }

    public Long getHasta() {
        return hasta;
    }

    public void setHasta(Long hasta) {
        this.hasta = hasta;
    }

    public Cpa getId_cpa() {
        return id_cpa;
    }

    public void setId_cpa(Cpa id_cpa) {
        this.id_cpa = id_cpa;
    }
}
