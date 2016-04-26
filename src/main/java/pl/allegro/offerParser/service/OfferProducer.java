package pl.allegro.offerParser.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegro.offerParser.DTO.Offer;
import pl.allegro.offerParser.DTO.Page;

import java.io.IOException;
import java.util.List;

@Service
public class OfferProducer {

    private final ParserService parserService;

    @Autowired
    public OfferProducer(ParserService parserService) {
        this.parserService = parserService;
    }

    public List<Offer> produceFromPage(Page page) throws IOException {
        Document doc = Jsoup.connect(page.getUrl()).get();
        Elements articleOfferElements = doc.select("article.offer");
        return parserService.matchOffersFormDOMElements(articleOfferElements);
    }
}
