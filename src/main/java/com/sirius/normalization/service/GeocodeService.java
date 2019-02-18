package com.sirius.normalization.service;

import com.sirius.normalization.model.*;
import com.sirius.normalization.repository.*;
import com.sirius.normalization.util.GeocodeNormalizerCpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GeocodeService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private SubRegionRepository subRegionRepository;

    public Optional<Cpa> findCpa(GeocodeNormalizerCpa geocodeNormalizer){
        if(geocodeNormalizer.getRegion() != null && !geocodeNormalizer.getRegion().isEmpty()) {
            Optional<Region> regionOptional = regionRepository.findFirstByNombreIgnoreCaseContaining(geocodeNormalizer.getRegion());
            if (regionOptional.isPresent()) {
                if(geocodeNormalizer.getSubRegion() != null && !geocodeNormalizer.getSubRegion().isEmpty()) {
                    Optional<SubRegion> subRegionOptional = subRegionRepository.findFirstByNombreIgnoreCaseContainingAndProvincia(geocodeNormalizer.getSubRegion(), regionOptional.get());
                    if (subRegionOptional.isPresent()) {
                        if(geocodeNormalizer.getLocality() != null && !geocodeNormalizer.getLocality().isEmpty()) {
                            List<Locality> localityList = localityRepository.findByNombreIgnoreCaseContainingAndParaje(geocodeNormalizer.getLocality(), subRegionOptional.get());
                            if (!localityList.isEmpty()){
                                Optional<Cpa> optionalCpa = localityList.stream()
                                        .filter(x -> x.getCpa() != null)
                                        .map(Locality::getCpa)
                                        .findAny();
                                if(geocodeNormalizer.getStreet() == null || geocodeNormalizer.getStreet().isEmpty() || geocodeNormalizer.getStreetNumber() == null){
                                    return optionalCpa;
                                }else {
                                    Optional<Cpa> optionalCpaAddress = localityList.stream()
                                            .map(locality -> {
                                                Optional<Street> streetOptional = streetRepository.findFirstByNombreAbreviadoIgnoreCaseContainingAndLocalidad(geocodeNormalizer.getStreet(), locality);
                                                if (streetOptional.isPresent()) {
                                                    return streetOptional;
                                                } else {
                                                    return streetRepository.findFirstByNombreCompletoIgnoreCaseContainingAndLocalidad(geocodeNormalizer.getStreet(), locality);
                                                }
                                            })
                                            .filter(Optional::isPresent)
                                            .map(Optional::get)
                                            .findAny()
                                            .map(street -> {
                                                return addressRepository.findByCalle(street)
                                                .stream()
                                                .filter(address -> address.getDesde() <= geocodeNormalizer.getStreetNumber() && address.getHasta() >= geocodeNormalizer.getStreetNumber())
                                                .findAny()
                                                .map(Address::getCpa);
                                            })
                                            .filter(Optional::isPresent)
                                            .map(Optional::get);
                                    if(optionalCpaAddress.isPresent()){
                                        return optionalCpaAddress;
                                    }else {
                                        return optionalCpa;
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
