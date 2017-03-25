package uk.tanton.legislation.fetcher.javax;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.Year;

/**
 * Created by tantop01 on 14/03/17.
 */
public class YearAdapter extends XmlAdapter<String, Year> {
    @Override
    public Year unmarshal(String v) throws Exception {
        return Year.parse(v);
    }

    @Override
    public String marshal(Year v) throws Exception {
        return String.valueOf(v.getValue());
    }
}
