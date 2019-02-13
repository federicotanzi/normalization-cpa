package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
    List<Region> findByNameIgnoreCaseContaining(String name);
}
