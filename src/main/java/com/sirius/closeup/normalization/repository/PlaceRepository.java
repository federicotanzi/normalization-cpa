package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Address;
import com.sirius.closeup.normalization.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    List<Place> findByNameIgnoreCaseContaining(String name);
    Optional<Place> findByAddress(Address address);
    List<Place> findAll();
}
