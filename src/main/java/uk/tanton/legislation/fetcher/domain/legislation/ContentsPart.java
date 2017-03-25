package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlElement;

public class ContentsPart extends BaseContents {

    @XmlElement(name = "ContentsNumber")
    private String contentsNumber;

    @XmlElement(name = "ContentsTitle")
    private String contentsTitle;

    @XmlElement(name = "ContentsItem")
    private ContentsItem[] contentsItems;



}
