package com.sirius.normalization.repository;

import com.sirius.normalization.model.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegionRepository extends CrudRepository<Region, Long> {
    Optional<Region> findFirstByNombreIgnoreCaseContaining(String nombre);
}
