package pl.allegro.offerParser.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Offer {

    private final String title;
    private final String price;

    @JsonCreator
    public Offer(
            @JsonProperty("title") String title,
            @JsonProperty("price") String price) {
        this.title = title;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
