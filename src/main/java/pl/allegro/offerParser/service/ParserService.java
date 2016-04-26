package pl.allegro.offerParser.service;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pl.allegro.offerParser.DTO.Offer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ParserService {

    private static String stringPattern = "([0-9].)*[0-9]+,[0-9]+...";
    private static Pattern pattern = Pattern.compile(stringPattern);

    public List<Offer> matchOffersFormDOMElements(Elements elements) {
        return elements
                .stream()
                .map(
                        offerElement -> this.matchOffer(offerElement)
                ).collect(Collectors.toList());

    }

    private Offer matchOffer(Element element) {
        String title = element.select(".offer-title").text();
        String price = "brak";
        Matcher matcher = pattern.matcher(
                element
                        .select(".offer-price")
                        .select(".offer-buy-now")
                        .select(".statement")
                        .text()
        );

        if (matcher.find()) {
            price = matcher.group(0);
        }

        return new Offer(title, price);
    }
}
