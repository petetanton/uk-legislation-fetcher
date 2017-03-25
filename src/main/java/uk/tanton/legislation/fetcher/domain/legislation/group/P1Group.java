package uk.tanton.legislation.fetcher.domain.legislation.group;

import uk.tanton.legislation.fetcher.domain.legislation.BaseContents;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;
import java.util.List;

public class P1Group extends BaseContents {

    @XmlAttribute(name = "ConfersPower")
    private boolean confersPower;

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "P1")
    private P1[] p1;

    public List<P1> getP1() {
        return Arrays.asList(p1);
    }

    public String getTitle() {
        return title;
    }
}
