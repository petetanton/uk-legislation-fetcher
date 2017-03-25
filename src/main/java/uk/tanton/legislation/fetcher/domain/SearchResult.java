package uk.tanton.legislation.fetcher.domain;

import uk.tanton.legislation.fetcher.domain.searchresult.Entry;
import uk.tanton.legislation.fetcher.domain.searchresult.Link;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "feed", namespace = "http://www.w3.org/2005/Atom")
public class SearchResult {

    @XmlElement
    private String id;

    @XmlElement
    private Link link;

    @XmlElement
    private Date updated;

    @XmlElement
    private String title;


    @XmlElement(name = "itemsPerPage")
    private int itemsPerPage;

    @XmlElement(name = "startIndex")
    private int startIndex;

    @XmlElement(name = "page")
    private int page;

    @XmlElement(name = "morePages")
    private int morePages;

    @XmlElement
    private Entry[] entry;

    public List<Entry > getEntry() {
        return Arrays.asList(entry);
    }

    public String getId() {
        return id;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public Link getLink() {
        return link;
    }

    public int getMorePages() {
        return morePages;
    }

    public int getPage() {
        return page;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getTitle() {
        return title;
    }

    public Date getUpdated() {
        return updated;
    }


    //    <openSearch:Query role="request" leg:type="*" leg:start-year="1990" leg:end-year="2000"> </openSearch:Query>
//    <leg:facets>



}
