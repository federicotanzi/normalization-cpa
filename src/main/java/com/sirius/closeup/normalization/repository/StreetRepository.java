package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Locality;
import com.sirius.closeup.normalization.model.Street;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StreetRepository extends CrudRepository<Street, Long> {
    List<Street> findByNameContainingIgnoreCase(String name);
    List<Street> findByNameContainingIgnoreCaseAndPreType(String name,String preType);
    Optional<Street> findByNameAndNeighborhood(String name, Locality locality);
    List<Street> findByNameContainingIgnoreCaseAndNeighborhood(String name, Locality locality);
    List<Street> findByNameContainingIgnoreCaseAndNeighborhoodAndPreType(String name, Locality locality, String preType);
}
