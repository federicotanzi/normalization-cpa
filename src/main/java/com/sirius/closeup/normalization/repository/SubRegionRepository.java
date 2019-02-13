package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Region;
import com.sirius.closeup.normalization.model.SubRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubRegionRepository extends CrudRepository<SubRegion, Long> {
    List<SubRegion> findByNameIgnoreCaseContaining(String name);
    Optional<SubRegion> findByNameAndRegion(String name, Region region);
    List<SubRegion> findByNameIgnoreCaseContainingAndRegion(String name, Region region);
}
