package uk.tanton.legislation.fetcher.domain.searchresult;

import uk.tanton.legislation.fetcher.javax.YearAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Year;

/**
 * Created by tantop01 on 14/03/17.
 */
public class XmlYear {

    @XmlAttribute(name = "Value")
    @XmlJavaTypeAdapter(YearAdapter.class)
    private Year value;

    public Year getValue() {
        return value;
    }
}
