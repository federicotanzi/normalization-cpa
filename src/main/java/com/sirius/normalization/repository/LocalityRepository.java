package com.sirius.normalization.repository;

import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.SubRegion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
    List<Locality> findByNombre(String nombre);
    List<Locality> findByNombreIgnoreCaseContainingAndParaje(String nombre, SubRegion paraje);
}
