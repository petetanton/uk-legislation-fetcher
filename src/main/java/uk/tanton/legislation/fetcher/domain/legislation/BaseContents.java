package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

public class BaseContents {

    @XmlAttribute(name = "ContentRef")
    private String contentRef;

    @XmlAttribute(name = "IdURI")
    private String idUri;

    @XmlAttribute(name = "RestrictStartDate")
    private Date restrictStartDate;

    @XmlAttribute(name = "RestrictExtent")
    private String restrictExtent;

    @XmlAttribute(name = "DocumentURI")
    private String documentURI;

    @XmlAttribute(name = "NumberOfProvisions")
    private String numberOfProvisions;

    @XmlAttribute(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public String getNumberOfProvisions() {
        return numberOfProvisions;
    }

    public String getContentRef() {
        return contentRef;
    }

    public String getDocumentURI() {
        return documentURI;
    }

    public String getIdUri() {
        return idUri;
    }

    public String getRestrictExtent() {
        return restrictExtent;
    }

    public Date getRestrictStartDate() {
        return restrictStartDate;
    }
}
