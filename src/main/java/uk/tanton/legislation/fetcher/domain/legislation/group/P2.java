package uk.tanton.legislation.fetcher.domain.legislation.group;

import javax.xml.bind.annotation.XmlElement;

public class P2 extends BaseP {

    @XmlElement(name = "P2para")
    private P2Para p2para;

    public P2Para getP2para() {
        return p2para;
    }
}
