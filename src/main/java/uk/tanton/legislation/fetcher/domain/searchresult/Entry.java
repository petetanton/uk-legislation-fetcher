package uk.tanton.legislation.fetcher.domain.searchresult;

import javax.xml.bind.annotation.XmlElement;
import java.time.Year;
import java.util.Date;

/**
 * Created by tantop01 on 14/03/17.
 */
public class Entry {

    @XmlElement
    private String id;

    @XmlElement
    private String title;

    @XmlElement
    private Link[] link;

    @XmlElement
    private Author author;

    @XmlElement
    private Date updated;

    @XmlElement
    private Date published;

    @XmlElement(name = "DocumentMainType")
    private DocumentMainType documentMainType;

    @XmlElement(name = "Year")
    private XmlYear year;

    @XmlElement
    private Category[] category;

    public Author getAuthor() {
        return author;
    }

    public Category[] getCategory() {
        return category;
    }

    public DocumentMainType getDocumentMainType() {
        return documentMainType;
    }

    public String getId() {
        return id;
    }

    public Link[] getLink() {
        return link;
    }

    public Date getPublished() {
        return published;
    }

    public String getTitle() {
        return title;
    }

    public Date getUpdated() {
        return updated;
    }

    public Year getYear() {
        return year.getValue();
    }
}
