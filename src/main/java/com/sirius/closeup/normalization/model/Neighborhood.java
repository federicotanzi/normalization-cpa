package com.sirius.closeup.normalization.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String postalCode;
    @ManyToOne
    private City city;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "coordinate",columnDefinition="Geometry(Point,4326)")
    private Point coordinate;

    public Neighborhood() {
    }

    public Neighborhood(String name, String postalCode, City city) {
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Neighborhood(String name, String postalCode, City city, Point coordinate) {
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
        this.coordinate = coordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }
}
