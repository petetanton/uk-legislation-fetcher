package uk.tanton.legislation.fetcher.domain.searchresult;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by tantop01 on 14/03/17.
 */
public class Link {
    //    <link rel="self" type="application/atom+xml" href="http://legislation.data.gov.uk/1990-2000/data.feed"/>

    @XmlAttribute
    private String rel;

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String href;
}
