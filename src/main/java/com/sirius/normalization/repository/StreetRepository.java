package com.sirius.normalization.repository;

import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.Street;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StreetRepository extends CrudRepository<Street, Long> {
    List<Street> findByNombreAbreviadoIgnoreCaseContaining(String nombre_abreviado);
    List<Street> findByNombreAbreviadoAndLocalidad(String nombre_abreviado, Locality localidad);
    List<Street> findByNombreCompletoIgnoreCaseContaining(String nombre_abreviado);
    List<Street> findByNombreCompletoAndLocalidad(String nombre_abreviado, Locality localidad);
    List<Street> findByLocalidad(Locality localidad);
}
