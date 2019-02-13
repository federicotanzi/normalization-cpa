package com.sirius.closeup.normalization.model;

import com.sirius.closeup.normalization.util.GeocodeAddress;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class PerformedSearchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AddressType addressType;

    private Long cityId;

    private Long neighborhoodId;

    private Long streetId;

    private Long addressId;

    private String placeName;

    private Double score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "performed_search_id")
    @Valid
    private PerformedSearch performedSearch;

    public PerformedSearchResult() {
    }

    public PerformedSearchResult(PerformedSearch performedSearch, GeocodeAddress geocodeAddress) {
        Address address = geocodeAddress.getAddress();
        Street street = address.getStreet1();
        Neighborhood neighborhood = street.getNeighborhood();
        City city = neighborhood.getCity();
        this.cityId = city.getId();
        this.neighborhoodId = neighborhood.getId();
        this.streetId = street.getId();
        this.addressId = address.getId();
        this.addressType = geocodeAddress.getAddressType();
        this.score = geocodeAddress.getScore();
        this.placeName = geocodeAddress.getPlaceName();
        this.performedSearch = performedSearch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public PerformedSearch getPerformedSearch() {
        return performedSearch;
    }

    public void setPerformedSearch(PerformedSearch performedSearch) {
        this.performedSearch = performedSearch;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
