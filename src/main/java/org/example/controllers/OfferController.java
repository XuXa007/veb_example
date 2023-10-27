package org.example.controllers;

import org.example.dtos.OfferDto;
import org.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    Iterable<OfferDto> all() {
        return offerService.getAllOffers();
    }

    @PostMapping("/offer")
    OfferDto newOffer(@RequestBody OfferDto newOffer) {
        return offerService.registerOffer(newOffer);
    }

    @DeleteMapping("/offer/{offerID}")
    void deleteOffer(@PathVariable("offerID") OfferDto offerDto) {
        offerService.registerOffer(offerDto);
    }

    @PutMapping("/offer/{offerID}")
    public OfferDto updateOffer(@PathVariable("offerID") UUID offerID, @RequestBody OfferDto updateOffer) {
        return offerService.updateOffer(offerID, updateOffer);
    }
}
