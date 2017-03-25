package uk.tanton.legislation.fetcher.domain;

import uk.tanton.legislation.fetcher.domain.legislation.Contents;
import uk.tanton.legislation.fetcher.domain.legislation.Primary;

import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name = "Legislation", namespace = "http://www.legislation.gov.uk/namespaces/legislation")
public class Legislation {


    @XmlElement(name = "Contents")
    private Contents contents;

    @XmlElement(name = "Primary")
    private Primary primary;

    public Contents getContents() {
        return contents;
    }

    public Primary getPrimary() {
        return primary;
    }
}



