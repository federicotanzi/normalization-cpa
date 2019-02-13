package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.PerformedSearch;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PerformedSearchRepository extends CrudRepository<PerformedSearch, Long> {
    Optional<PerformedSearch> findByAddress(String address);
    boolean existsByAddress(String address);
}
