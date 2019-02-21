package com.sirius.normalization.util;

import com.sirius.normalization.model.Cp;
import com.sirius.normalization.model.Cpa;

public class CpaResult {

    private String cp;
    private String cpa;

    public CpaResult() {
        this.cp = "";
        this.cpa = "";
    }

    public CpaResult(Cp cp, Cpa cpa) {
        if(cp == null) {
            this.cp = "";
        } else {
            this.cp = cp.getCp();
        }
        if(cpa == null){
            this.cpa = "";
        } else {
            this.cpa = cpa.getCpa();
        }

    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCpa() {
        return cpa;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }
}
