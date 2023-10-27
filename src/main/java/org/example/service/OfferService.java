package org.example.service;

import org.example.dtos.OfferDto;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    List<OfferDto> getAllOffers();

    OfferDto registerOffer(OfferDto offerDto);
    void deleteOffer(UUID offerID);

    OfferDto updateOffer(UUID offerID, OfferDto updateOffer);
}
