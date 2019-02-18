package com.sirius.normalization.util;

public class GeocodeNormalizerCpa {

    private String region;
    private String subRegion;
    private String locality;
    private String street;
    private Long streetNumber;

    public boolean isCF(){
        String s = region.toUpperCase();
        return s.equals("Ciudad Autonoma de Buenos Aires".toUpperCase()) || s.equals("CF") || s.equals("CAPITAL FEDERAL");
    }

    public String getRegionN() {
        if(isCF()){
            return "CAPITAL FEDERAL";
        } else {
            return region;
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegionN() {
        if(isCF()){
            return "CAPITAL FEDERAL";
        } else {
            return subRegion;
        }
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getLocalityN() {
        if(isCF()){
            return "CIUDAD AUTONOMA BUENOS AIRES";
        } else {
            return locality;
        }
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }
}
