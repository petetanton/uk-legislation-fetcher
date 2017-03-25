package uk.tanton.legislation.fetcher.domain.legislation;

import javax.xml.bind.annotation.XmlElement;

public class ContentsItem extends BaseContents {

    @XmlElement(name = "ContentsNumber")
    private String contentsNumber;

    @XmlElement(name = "ContentsTitle")
    private String contentsTitle;

}

//           <ContentsItem ContentRef="section-1" IdURI="http://www.legislation.gov.uk/id/ukpga/2000/32/section/1"
////                  RestrictStartDate="2001-11-04"
////                  DocumentURI="http://www.legislation.gov.uk/ukpga/2000/32/section/1" RestrictExtent="N.I.">
////              <ContentsNumber>1</ContentsNumber>
////              <ContentsTitle>Name of the police in Northern Ireland.</ContentsTitle>
////          </ContentsItem>