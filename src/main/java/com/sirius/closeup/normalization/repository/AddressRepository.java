package com.sirius.closeup.normalization.repository;

import com.sirius.closeup.normalization.model.Address;
import com.sirius.closeup.normalization.model.Street;
import com.vividsolutions.jts.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Long> {
    @Query(
            value = "select * from Address c where ST_DWithin(c.coordinate, ?1, 0.000006) order by ST_Distance(c.coordinate, ?1) limit 1",
            nativeQuery = true
    )
    Optional<Address> findMinDistance(Geometry filter);
    @Query(
            value = "select * from Address c where ST_DWithin(c.coordinate, ?1, 0.05) and street1_id = ?2 and street_number = ?3 order by ST_Distance(c.coordinate, ?1) limit 1",
            nativeQuery = true
    )
    Optional<Address> findMinDistanceByStreet1AndStreetNumber(Geometry filter,Long street1,String streetNumber);
    @Query(
            value = "select * from Address c where ST_DWithin(c.coordinate, ?1, 0.05) and street1_id = ?2 and street2_id = ?3 order by ST_Distance(c.coordinate, ?1) limit 1",
            nativeQuery = true
    )
    Optional<Address> findMinDistanceByStreet1AndStreet2(Geometry filter,Long street1,Long street2);
    Optional<Address> findByStreet1AndStreetNumber(Street street1,String streetNumber);
    Optional<Address> findByStreet1AndStreet2(Street street1,Street street2);
}
