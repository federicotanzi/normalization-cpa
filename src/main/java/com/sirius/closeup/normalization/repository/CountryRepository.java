package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
