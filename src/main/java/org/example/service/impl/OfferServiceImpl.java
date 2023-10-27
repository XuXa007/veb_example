package org.example.service.impl;

import org.example.dtos.BrandDto;
import org.example.dtos.OfferDto;
import org.example.exception.NotFoundException;
import org.example.models.Model;
import org.example.models.Offer;
import org.example.models.Users;
import org.example.repo.OfferRepository;
import org.example.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private String offer = "offer";

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public OfferDto registerOffer(OfferDto offerDto) {
        Offer b = modelMapper.map(offerDto, Offer.class);
        return modelMapper.map(offerRepository.save(b), OfferDto.class);
    }

    @Override
    public void deleteOffer(UUID offerID) {
        Offer offer = offerRepository.findById(offerID)
                .orElseThrow(() -> new NotFoundException("Could not find user by id: " + offerID));
        offerRepository.delete(offer);
    }

    @Override
    public OfferDto updateOffer(UUID offerID, OfferDto updateOffer) {
        Offer existingOffer = offerRepository.findById(offerID).orElseThrow(() -> new NotFoundException("Could not find" + offer + " by id: " + offerID));

        Model existingModel = modelMapper.map(updateOffer.getModel(), Model.class);
        Users existingUser = modelMapper.map(updateOffer.getUsers(), Users.class);

        existingOffer.setModel(existingModel);
        existingOffer.setUsers(existingUser);

        existingOffer.setId(updateOffer.getId());
        existingOffer.setDescription(updateOffer.getDescription());
        existingOffer.setEngine(updateOffer.getEngine());
        existingOffer.setImageUrl(updateOffer.getImageURL());
        existingOffer.setMileage(updateOffer.getMileage());
        existingOffer.setPrice(updateOffer.getPrice());
        existingOffer.setTransmission(updateOffer.getTransmission());
        existingOffer.setYear(updateOffer.getYear());
        existingOffer.setCreated(updateOffer.getCreated());
        existingOffer.setModified(updateOffer.getModified());

        Offer savedOffer = offerRepository.save(existingOffer);
        return modelMapper.map(savedOffer, OfferDto.class);
    }
}
