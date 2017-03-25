package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class PrimaryPrelims {

    @XmlAttribute(name = "IdURI")
    private String idUri;

    @XmlAttribute(name = "RestrictStartDate")
    private Date restrictStartDate;

    @XmlAttribute(name = "RestrictExtent")
    private String restrictExtent;

    @XmlAttribute(name = "DocumentURI")
    private String documentURI;

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Number")
    private String number;

    @XmlElement(name = "LongTitle")
    private String longTitle;

}
