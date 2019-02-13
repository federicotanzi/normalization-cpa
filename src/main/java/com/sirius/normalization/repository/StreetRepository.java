package com.sirius.normalization.repository;

import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.Street;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StreetRepository extends CrudRepository<Street, Long> {
    Optional<Street> findByNombreAbreviadoIgnoreCaseContainingAndLocalidad(String nombre_abreviado, Locality localidad);
}
