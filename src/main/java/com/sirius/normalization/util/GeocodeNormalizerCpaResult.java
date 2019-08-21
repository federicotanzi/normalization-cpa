package com.sirius.normalization.util;

public class GeocodeNormalizerCpaResult {

    private String region;
    private String subRegion;
    private String locality;
    private String street;
    private Long streetNumber;

    public static GeocodeNormalizerCpaResult newInstance(GeocodeNormalizerCpa geocodeNormalizerCpa) {
        GeocodeNormalizerCpaResult g = new GeocodeNormalizerCpaResult();
        boolean isCf = isCF(geocodeNormalizerCpa.getRegion());
        String regionAux = geocodeNormalizerCpa.getRegion();
        if(isCf){
            regionAux = "CAPITAL FEDERAL";
        }
        String subRegionAux = geocodeNormalizerCpa.getSubRegion();
        if(isCf){
            subRegionAux =  "CAPITAL FEDERAL";
        }
        String localityAux = geocodeNormalizerCpa.getLocality();
        if(isCf){
             localityAux = "CIUDAD AUTONOMA BUENOS AIRES";
        } else if(localityAux.equals("INGENIERO LUIS A. HUERGO")){
            localityAux = "INGENIERO HUERGO";
        } else if(localityAux.equals("LANUS OESTE")){
            localityAux = "LANUS";
        } else if(localityAux.equals("LANUS ESTE")){
            localityAux = "LANUS";
        } else if(localityAux.equals("GENERAL MARTIN M. GUEMES")){
            localityAux = "GENERAL GUEMES";
        }

        String streetAux = geocodeNormalizerCpa.getStreet();
        streetAux = streetAux.replaceAll("\\.",  "");
        streetAux = streetAux.replaceAll("'", " ");
        streetAux = streetAux.replaceAll("%", "Ñ");
        streetAux = streetAux.replaceAll("1RO","1");
        streetAux = streetAux.replaceAll("AVENIDA","AV");

        switch (streetAux) {
            case "A B FERRARI":
                streetAux = "ANDRES FERRARI";
                break;
            case "AV C MENGELLE":
                streetAux = "ADOLFO MENGELLE";
                break;
            case "AV ABANDERADO GRANDOLI":
                streetAux = "ABANDERADO G GRANDOLI";
                break;
            case "P G ALMAFUERTE":
                streetAux = "ALMAFUERTE";
                break;
            case "VALENTIN ALSINA":
                streetAux = "ALSINA";
                break;
        }



        g.setRegion(regionAux);
        g.setSubRegion(subRegionAux);
        g.setLocality(localityAux);
        g.setStreet(streetAux);
        g.setStreetNumber(geocodeNormalizerCpa.getStreetNumber());
        return g;
    }

    public boolean isPar(){
        return streetNumber % 2 == 0;
    }

    public static boolean isCF(String region){
        return region.equals("Ciudad Autonoma de Buenos Aires".toUpperCase()) || region.equals("CF") || region.equals("CAPITAL FEDERAL");
    }

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
        this.street = street;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

}
