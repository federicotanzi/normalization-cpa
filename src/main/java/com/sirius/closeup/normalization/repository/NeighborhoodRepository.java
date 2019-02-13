package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.City;
import com.sirius.closeup.normalization.model.Locality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NeighborhoodRepository extends CrudRepository<Locality, Long> {
    List<Locality> findByNameIgnoreCaseContaining(String name);
    Optional<Locality> findByNameAndCity(String name, City city);
    List<Locality> findByPostalCodeAndCity(String postalCode, City city);
    Optional<Locality> findByNameAndPostalCodeAndCity(String name, String postalCode, City city);
    List<Locality> findByNameIgnoreCaseContainingAndCity(String name, City city);
}
