package com.sirius.closeup.normalization.model;

public enum AddressType {
    StreetAddress,StreetInt,StreetName,Locality,POI,Nil;

    public static AddressType valueType(String value){
        switch (value){
            case "PointAddress":
                return StreetAddress;
            case "StreetAddress":
                return StreetAddress;
            case "StreetAddressExt":
                return StreetAddress;
            case "StreetInt":
                return StreetInt;
            case "StreetName":
                return StreetName;
            case "Locality":
                return Locality;
            case "PostalLoc":
                return Locality;
            case "Postal":
                return Locality;
            case "POI":
                return POI;
            default:
                return Nil;
        }
    }
}
