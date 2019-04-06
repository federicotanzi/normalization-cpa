package com.sirius.normalization.repository;

import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.Street;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StreetRepository extends CrudRepository<Street, Long> {
    Optional<Street> findFirstByNombreAbreviadoIgnoreCaseContaining(String nombre_abreviado);
    Optional<Street> findFirstByNombreAbreviadoIgnoreCaseContainingAndLocalidad(String nombre_abreviado, Locality localidad);
    Optional<Street> findFirstByNombreCompletoIgnoreCaseContaining(String nombre_abreviado);
    Optional<Street> findFirstByNombreCompletoIgnoreCaseContainingAndLocalidad(String nombre_abreviado, Locality localidad);
}
