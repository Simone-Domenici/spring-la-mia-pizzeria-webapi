package org.lessons.java.spring_la_mia_pizzeria_crud.service;

import java.util.Optional;
import org.lessons.java.spring_la_mia_pizzeria_crud.model.Offer;
import org.lessons.java.spring_la_mia_pizzeria_crud.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public Optional<Offer> findById(Integer id) {
        return offerRepository.findById(id);
    }

    public void deleteById(Integer id) {
        offerRepository.deleteById(id);
    }
}
