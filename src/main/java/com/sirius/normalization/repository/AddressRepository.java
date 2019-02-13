package com.sirius.normalization.repository;

import com.sirius.normalization.model.Address;
import com.sirius.normalization.model.Street;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findByCalle(Street calle);
}
