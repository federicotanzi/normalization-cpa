package com.sirius.normalization.repository;

import com.sirius.normalization.model.Region;
import com.sirius.normalization.model.SubRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubRegionRepository extends CrudRepository<SubRegion, Long> {
    Optional<SubRegion> findFirstByNombreIgnoreCaseContaining(String nombre);
    Optional<SubRegion> findFirstByNombreIgnoreCaseContainingAndProvincia(String nombre, Region provincia);
}
