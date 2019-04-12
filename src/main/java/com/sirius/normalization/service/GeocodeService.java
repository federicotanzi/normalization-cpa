package com.sirius.normalization.service;

import com.sirius.normalization.model.Address;
import com.sirius.normalization.model.Locality;
import com.sirius.normalization.model.Region;
import com.sirius.normalization.model.Street;
import com.sirius.normalization.repository.AddressRepository;
import com.sirius.normalization.repository.LocalityRepository;
import com.sirius.normalization.repository.RegionRepository;
import com.sirius.normalization.repository.StreetRepository;
import com.sirius.normalization.util.CpaResult;
import com.sirius.normalization.util.GeocodeNormalizerCpaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<CpaResult> findCpa(GeocodeNormalizerCpaResult geocodeNormalizer){
        if(geocodeNormalizer.getRegion() != null && !geocodeNormalizer.getRegion().isEmpty()) {
            Optional<Region> regionOptional = regionRepository.findFirstByNombreIgnoreCaseContaining(geocodeNormalizer.getRegion());
            if (regionOptional.isPresent()) {
                if(geocodeNormalizer.getLocality() != null && !geocodeNormalizer.getLocality().isEmpty()) {
                    List<Locality> localityList = localityRepository.findByNombre(geocodeNormalizer.getLocality()).stream().filter(x -> x.getParaje().getProvincia().getId().equals(regionOptional.get().getId())).collect(Collectors.toList());
                    if(localityList.isEmpty()) {
                        localityList = localityRepository.findByNombre(geocodeNormalizer.getSubRegion()).stream().filter(x -> x.getParaje().getProvincia().getId().equals(regionOptional.get().getId())).collect(Collectors.toList());
                    }
                    if (!localityList.isEmpty()){
                        Optional<CpaResult> optionalCpa = localityList.stream()
                                    .filter(x -> x.getCpa() != null || x.getCp() != null)
                                    .map(x -> new CpaResult(x.getCp(),x.getCpa()))
                                    .findAny();
                        if(geocodeNormalizer.getHasIntersection() || geocodeNormalizer.getStreet() == null || geocodeNormalizer.getStreet().isEmpty() || geocodeNormalizer.getStreetNumber() == null){
                            return optionalCpa;
                        }else {
                            Optional<CpaResult> optionalCpaAddress = localityList.parallelStream()
                                    .map(locality -> findStreetByLocality(geocodeNormalizer.getStreet(),locality))
                                    .flatMap(List::stream)
                                    .map(street -> addressRepository.findByCalle(street))
                                    .flatMap(List::stream)
                                    .filter(address -> filterAddress(geocodeNormalizer,address))
                                    .findAny()
                                    .map(x -> new CpaResult(x.getCp(),x.getCpa()));
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
        return Optional.empty();
    }

    private boolean filterAddress(GeocodeNormalizerCpaResult geocodeNormalizer,Address address){
       return geocodeNormalizer.isPar() == address.isPar() && address.getDesde() <= geocodeNormalizer.getStreetNumber() && address.getHasta() >= geocodeNormalizer.getStreetNumber();
    }

    private List<Street> findStreetByLocality(String street,Locality locality){
        List<Street> streetList = streetRepository.findByNombreAbreviadoAndLocalidad(street, locality);
        if (streetList.isEmpty()) {
            streetList = streetRepository.findByNombreCompletoAndLocalidad(street, locality);
            if (streetList.isEmpty()) {
                List<Street> byLocalidad = streetRepository.findByLocalidad(locality);
                String[] splitStreet = street.split(" ");
                streetList = byLocalidad.stream().filter(streetAux -> {
                    for (String s : splitStreet) {
                        if(!streetAux.getNombreCompleto().contains(s)){
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
                if (streetList.isEmpty()) {
                    streetList = byLocalidad.stream().filter(streetAux -> {
                        for (String s : splitStreet) {
                            if(!streetAux.getNombreAbreviado().contains(s)){
                                return false;
                            }
                        }
                        return true;
                    }).collect(Collectors.toList());
                }
            }
        }
        return streetList;
    }

}
