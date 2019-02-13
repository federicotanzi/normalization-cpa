package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.City;
import com.sirius.closeup.normalization.model.SubRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByNameIgnoreCaseContaining(String name);
    Optional<City> findByNameAndSubRegion(String name, SubRegion subRegion);
    List<City> findByNameIgnoreCaseContainingAndSubRegion(String name, SubRegion subRegion);
}
