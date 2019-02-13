package com.sirius.closeup.normalization.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PerformedSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "performedSearch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PerformedSearchResult> performedSearchResults;

    public PerformedSearch() {
        this.performedSearchResults = new HashSet<>(0);
    }

    public PerformedSearch(String address) {
        this.address = address;
        this.performedSearchResults = new HashSet<>(0);
    }

    public PerformedSearch(String address, Set<PerformedSearchResult> performedSearchResults) {
        this.address = address;
        this.performedSearchResults = performedSearchResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<PerformedSearchResult> getPerformedSearchResults() {
        return performedSearchResults;
    }

    public void setPerformedSearchResults(Set<PerformedSearchResult> performedSearchResults) {
        this.performedSearchResults = performedSearchResults;
    }

    public void addPerformedSearchResult(PerformedSearchResult performedSearchResult) {
        this.performedSearchResults.add(performedSearchResult);
    }
}
