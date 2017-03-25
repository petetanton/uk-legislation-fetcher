package uk.tanton.legislation.fetcher.domain.legislation.group;

import javax.xml.bind.annotation.XmlElement;

public class P1 extends BaseP {

    @XmlElement(name = "P1para")
    private P1Para p1Para;

    public P1Para getP1Para() {
        return p1Para;
    }
}
