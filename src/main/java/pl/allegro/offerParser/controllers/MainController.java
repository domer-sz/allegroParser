package pl.allegro.offerParser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.offerParser.DTO.Offer;
import pl.allegro.offerParser.DTO.Page;
import pl.allegro.offerParser.service.OfferProducer;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    private final OfferProducer offerProducer;

    @Autowired
    public MainController(OfferProducer offerProducer) {
        this.offerProducer = offerProducer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Offer>> getOffers(@RequestBody Page page) {
        try {
            return new ResponseEntity<List<Offer>>(offerProducer.produceFromPage(page),
                    HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
