package com.sirius.normalization.service;

import com.sirius.normalization.model.*;
import com.sirius.normalization.repository.*;
import com.sirius.normalization.util.GeocodeNormalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeocodeService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CpaRepository cpaRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private SubRegionRepository subRegionRepository;

    public Optional<Cpa> findCpa(GeocodeNormalizer geocodeNormalizer){
        if(geocodeNormalizer.getRegion() != null) {
            Optional<Region> regionOptional = regionRepository.findByNombreIgnoreCaseContaining(geocodeNormalizer.getRegion());
            if (regionOptional.isPresent()) {
                if(geocodeNormalizer.getSubRegion() != null) {
                    Optional<SubRegion> subRegionOptional = subRegionRepository.findByNombreIgnoreCaseContainingAndProvincia(geocodeNormalizer.getSubRegion(), regionOptional.get());
                    if (subRegionOptional.isPresent()) {
                        if(geocodeNormalizer.getLocality() != null) {
                            Optional<Locality> localityOptional = localityRepository.findByNombreIgnoreCaseContainingAndParaje(geocodeNormalizer.getLocality(), subRegionOptional.get());
                            if (localityOptional.isPresent()){
                                if(geocodeNormalizer.getStreet() == null){
                                    return Optional.ofNullable(localityOptional.get().getCpa());
                                } else {
                                    Optional<Street> streetOptional = streetRepository.findByNombreAbreviadoIgnoreCaseContainingAndLocalidad(geocodeNormalizer.getStreet(), localityOptional.get());
                                    if(streetOptional.isPresent()){
                                        if (geocodeNormalizer.getStreetNumber() != null){
                                            List<Address> byId_calle = addressRepository.findByCalle(streetOptional.get());
                                            if(byId_calle.isEmpty()){
                                                return Optional.ofNullable(localityOptional.get().getCpa());
                                            } else {
                                                return byId_calle.stream()
                                                        .filter(x -> x.getDesde() >= geocodeNormalizer.getStreetNumber() && x.getHasta() <= geocodeNormalizer.getStreetNumber())
                                                        .findAny().map(x -> x.getCpa());
                                            }
                                        }else {
                                            return Optional.ofNullable(localityOptional.get().getCpa());
                                        }
                                    } else {
                                        return Optional.ofNullable(localityOptional.get().getCpa());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

}
