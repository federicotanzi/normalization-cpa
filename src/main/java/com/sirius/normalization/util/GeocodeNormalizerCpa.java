package com.sirius.normalization.util;

public class GeocodeNormalizerCpa {

    private String region;
    private String subRegion;
    private String locality;
    private String street;
    private Long streetNumber;
    private Boolean hasIntersection;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region.toUpperCase();
    }


    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion.toUpperCase();
    }


    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality.toUpperCase();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street.toUpperCase();
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Boolean getHasIntersection() {
        return hasIntersection;
    }

    public void setHasIntersection(Boolean hasIntersection) {
        this.hasIntersection = hasIntersection;
    }
}
