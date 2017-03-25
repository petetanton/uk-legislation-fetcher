package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlElement;

public class Primary {

    @XmlElement(name = "PrimaryPrelims")
    private PrimaryPrelims primaryPrelims;

    @XmlElement(name = "Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public PrimaryPrelims getPrimaryPrelims() {
        return primaryPrelims;
    }
}
