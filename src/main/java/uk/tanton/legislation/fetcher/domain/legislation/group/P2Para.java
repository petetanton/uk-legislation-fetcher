package uk.tanton.legislation.fetcher.domain.legislation.group;

import uk.tanton.legislation.fetcher.javax.TextAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class P2Para {

    @XmlElement(name = "Text")
    @XmlJavaTypeAdapter(TextAdapter.class)
    private Text text;

    public Text getText() {
        return text;
    }
}
