package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Country;
import com.sirius.closeup.normalization.model.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Long> {
    Optional<Region> findByNameAndCountry(String name, Country country);
    List<Region> findByNameIgnoreCaseContaining(String name);
    List<Region> findByNameIgnoreCaseContainingAndCountry(String name, Country country);
}
