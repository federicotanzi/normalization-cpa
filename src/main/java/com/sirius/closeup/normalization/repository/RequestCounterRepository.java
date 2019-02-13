package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.RequestCounter;
import org.springframework.data.repository.CrudRepository;

import java.time.YearMonth;
import java.util.Optional;

public interface RequestCounterRepository extends CrudRepository<RequestCounter, Long> {
    Optional<RequestCounter> findByDate(YearMonth yearMonth);
}
