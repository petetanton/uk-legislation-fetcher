package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlElement;

public class Body extends BaseContents {

    @XmlElement(name = "Part")
    private Part part;

    public Part getPart() {
        return part;
    }
}
