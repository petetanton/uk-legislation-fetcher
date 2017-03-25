package uk.tanton.legislation.fetcher.domain.legislation;

import uk.tanton.legislation.fetcher.domain.legislation.group.P1Group;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pblock extends BaseContents {

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "P1group")
    private P1Group[] p1Group;

    public List<P1Group> getP1Group() {
        if (p1Group == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(p1Group);
    }

    public String getTitle() {
        return title;
    }
}
