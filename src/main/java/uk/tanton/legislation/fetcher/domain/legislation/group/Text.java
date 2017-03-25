package uk.tanton.legislation.fetcher.domain.legislation.group;

import java.util.Optional;

public class Text {

    private String content;

    public Text(final String content) {
        this.content = content;
    }

    public Optional<String> getContent() {
        return Optional.ofNullable(content);
    }

}
