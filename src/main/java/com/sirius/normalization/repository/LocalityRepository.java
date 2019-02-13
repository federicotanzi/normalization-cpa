package com.sirius.normalization.repository;

import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.SubRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
    Optional<Locality> findByNombreIgnoreCaseContainingAndParaje(String nombre, SubRegion paraje);
}
