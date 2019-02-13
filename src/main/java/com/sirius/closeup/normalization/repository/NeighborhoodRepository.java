package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.City;
import com.sirius.closeup.normalization.model.Neighborhood;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NeighborhoodRepository extends CrudRepository<Neighborhood, Long> {
    List<Neighborhood> findByNameIgnoreCaseContaining(String name);
    Optional<Neighborhood> findByNameAndCity(String name, City city);
    List<Neighborhood> findByPostalCodeAndCity(String postalCode, City city);
    Optional<Neighborhood> findByNameAndPostalCodeAndCity(String name,String postalCode, City city);
    List<Neighborhood> findByNameIgnoreCaseContainingAndCity(String name, City city);
}
