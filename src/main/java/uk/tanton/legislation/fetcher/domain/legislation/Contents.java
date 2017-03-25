package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contents {

    @XmlElement(name = "ContentsTitle")
    private String contentsTitle;

    @XmlElement(name = "ContentsPart")
    private ContentsPart[] contentsParts;

    public List<ContentsPart> getContentsParts() {
        if (contentsParts == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(contentsParts);
    }

    public String getContentsTitle() {
        return contentsTitle;
    }
}

