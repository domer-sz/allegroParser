package pl.allegro.offerParser.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Page {
    private final String url;

    @JsonCreator
    public Page(
            @JsonProperty("url") String url
    ) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                '}';
    }
}
