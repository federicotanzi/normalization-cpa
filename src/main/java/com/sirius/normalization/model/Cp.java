package com.sirius.normalization.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cp;

    public Cp() {
    }

    public Cp(String cp) {
        this.cp = cp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cpa) {
        this.cp = cpa;
    }
}
