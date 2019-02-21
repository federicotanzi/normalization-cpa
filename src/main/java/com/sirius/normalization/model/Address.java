package com.sirius.normalization.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Street calle;
    private Long desde;
    private Long hasta;
    @ManyToOne
    private Cpa cpa;
    @ManyToOne
    private Cp cp;

    public Address() {
    }

    public Address(Street calle, Long desde, Long hasta, Cpa cpa, Cp cp) {
        this.calle = calle;
        this.desde = desde;
        this.hasta = hasta;
        this.cpa = cpa;
        this.cp = cp;
    }

    public boolean isPar(){
        return desde % 2 == 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Street getCalle() {
        return calle;
    }

    public void setCalle(Street calle) {
        this.calle = calle;
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

    public Cpa getCpa() {
        return cpa;
    }

    public void setCpa(Cpa cpa) {
        this.cpa = cpa;
    }

    public Cp getCp() {
        return cp;
    }

    public void setCp(Cp cp) {
        this.cp = cp;
    }
}
