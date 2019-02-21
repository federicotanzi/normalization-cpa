package com.sirius.normalization.controller;

import com.sirius.normalization.service.GeocodeService;
import com.sirius.normalization.util.CpaResult;
import com.sirius.normalization.util.GeocodeNormalizerCpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders="*")
@RequestMapping("/api/cpa")
public class GeocodeController {

    @Autowired
    private GeocodeService geocodeService;

    @ResponseBody
    @RequestMapping(value = "/normalization", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CpaResult findCpa(@RequestBody GeocodeNormalizerCpa geocodeNormalizer){
        return geocodeService.findCpa(geocodeNormalizer).orElse(null);
    }

}
