package com.sirius.normalization.controller;

import com.sirius.normalization.model.Cpa;
import com.sirius.normalization.service.GeocodeService;
import com.sirius.normalization.util.GeocodeNormalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/api/normalization")
public class GeocodeController {

    @Autowired
    private GeocodeService geocodeService;

    @PostMapping
    public ResponseEntity<Cpa> findCpa(@RequestBody GeocodeNormalizer geocodeNormalizer){
        return geocodeService.findCpa(geocodeNormalizer).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
