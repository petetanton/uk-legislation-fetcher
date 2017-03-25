package uk.tanton.legislation.fetcher.domain.legislation.group;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Term {

    @XmlAttribute(name = "id")
    private String id;

    @XmlElement(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
