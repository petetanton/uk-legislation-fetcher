package uk.tanton.legislation.fetcher.domain.legislation.group;

import uk.tanton.legislation.fetcher.javax.TextAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class P1Para {

    @XmlElement(name = "P2")
    private P2[] p2;

    @XmlElement(name = "Text")
    @XmlJavaTypeAdapter(TextAdapter.class)
    private Text text;

    public Optional<Text> getText() {
        if (text != null) {
            return Optional.of(text);
        }
        return Optional.empty();
    }

    public Optional<List<P2>> getP2() {
        if (p2 != null && p2.length > 0) {
            return Optional.of(Arrays.asList(p2));
        }
        return Optional.empty();
    }
}
