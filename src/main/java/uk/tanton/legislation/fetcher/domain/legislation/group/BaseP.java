package uk.tanton.legislation.fetcher.domain.legislation.group;

import uk.tanton.legislation.fetcher.domain.legislation.BaseContents;

import javax.xml.bind.annotation.XmlElement;

public class BaseP extends BaseContents {

    @XmlElement(name = "Pnumber")
    private String pNumber;
}
