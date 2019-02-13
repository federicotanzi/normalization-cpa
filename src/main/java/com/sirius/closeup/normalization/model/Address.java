package com.sirius.closeup.normalization.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sirius.closeup.normalization.util.GeocodeNormalizerBatch;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Street street1;
    @ManyToOne
    private Street street2;
    private String streetNumber;
    private Boolean ruralZone;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "coordinate",columnDefinition="Geometry(Point,4326)")
    private Point coordinate;
    private String complement;
    @Column(columnDefinition="text")
    private String additional;
    private Integer quantity;
    @Column(columnDefinition="text")
    private String numbers;

    public Address() {
        this.quantity = 0;
        this.numbers = "";
        this.additional = "";
    }

    public Address(Street street1, Street street2, Boolean ruralZone, Point coordinate, String complement) {
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = 0;
        this.numbers = "";
        this.additional = "";
    }

    public Address(Street street1, Street street2, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers) {
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = "";
    }

    public Address(Street street1, Street street2, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers,String additional) {
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = additional;
    }

    public Address(Street street1, String streetNumber, Boolean ruralZone, Point coordinate, String complement) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = streetNumber;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = 0;
        this.numbers = "";
        this.additional = "";
    }

    public Address(Street street1, String streetNumber, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = streetNumber;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = "";
    }

    public Address(Street street1, String streetNumber, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers,String additional) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = streetNumber;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = additional;
    }

    public Address(Street street1, Boolean ruralZone, Point coordinate, String complement) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = 0;
        this.numbers = "";
        this.additional = "";
    }

    public Address(Street street1, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = "";
    }

    public Address(Street street1, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers,String additional) {
        this.street1 = street1;
        this.street2 = null;
        this.streetNumber = null;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = additional;
    }

    public Address(Street street1, Street street2, String streetNumber, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers) {
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = streetNumber;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = "";
    }

    public Address(Street street1, Street street2, String streetNumber, Boolean ruralZone, Point coordinate, String complement, Integer quantity, String numbers,String additional) {
        this.street1 = street1;
        this.street2 = street2;
        this.streetNumber = streetNumber;
        this.ruralZone = ruralZone;
        this.coordinate = coordinate;
        this.complement = complement;
        this.quantity = quantity;
        this.numbers = numbers;
        this.additional = additional;
    }

    @JsonIgnore
    public Boolean hasIntersection(){
        return street2 != null && streetNumber == null;
    }

    @JsonIgnore
    public Boolean hasStreetNumber(){
        return streetNumber != null && !streetNumber.isEmpty();
    }

    public void updateGeocodeNormalizerBatch(GeocodeNormalizerBatch geocodeNormalizerBatch){
        if(!geocodeNormalizerBatch.getComplement().isEmpty()) setComplement(geocodeNormalizerBatch.getComplement());
        if(!geocodeNormalizerBatch.getAdditional().isEmpty()) setAdditional(geocodeNormalizerBatch.getAdditional());
        if(geocodeNormalizerBatch.getQuantity() > 0) {
            setQuantity(geocodeNormalizerBatch.getQuantity());
            setNumbers(geocodeNormalizerBatch.getNumbers());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Street getStreet1() {
        return street1;
    }

    public void setStreet1(Street street1) {
        this.street1 = street1;
    }

    public Street getStreet2() {
        return street2;
    }

    public void setStreet2(Street street2) {
        this.street2 = street2;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Boolean getRuralZone() {
        return ruralZone;
    }

    public void setRuralZone(Boolean ruralZone) {
        this.ruralZone = ruralZone;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String toStreetString(){
        return hasIntersection() ? street1.toString() + " & " + street2.toString() : street1.toString();
    }

    public String toStreetNumberString(){
       return hasStreetNumber() ? streetNumber : "";
    }


}
