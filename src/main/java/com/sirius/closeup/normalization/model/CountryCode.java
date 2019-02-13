package com.sirius.closeup.normalization.model;

public enum CountryCode {

    ARG,MEX,PER,ECU,COL,Nil;

    public static CountryCode valueType(String value){
        switch (value){
            case "ARG":
                return ARG;
            case "ARGENTINA":
                return ARG;
            case "MEX":
                return MEX;
            case "MEXICO":
                return MEX;
            case "PER":
                return PER;
            case "PERU":
                return PER;
            case "ECU":
                return ECU;
            case "ECUADOR":
                return ECU;
            case "COL":
                return COL;
            case "COLOMBIA":
                return COL;
            default:
                return Nil;
        }
    }

}
