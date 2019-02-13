package com.sirius.closeup.normalization.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String preType;
    @ManyToOne
    private Locality locality;
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "coordinate",columnDefinition="Geometry(Point,4326)")
    private Point coordinate;

    public Street() {
    }

    public Street(String name, String preType, Locality locality) {
        this.name = name;
        this.preType = preType;
        this.locality = locality;
        this.coordinate = null;
    }

    public Street(String name, String preType, Locality locality, Point coordinate) {
        this.name = name;
        this.preType = preType;
        this.locality = locality;
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

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public String toString(){
        if(preType == null){
            return name;
        }else {
            return preType + " " + name;
        }
    }
}
