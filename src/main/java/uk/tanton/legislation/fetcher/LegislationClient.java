package uk.tanton.legislation.fetcher;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import uk.tanton.legislation.fetcher.domain.Legislation;
import uk.tanton.legislation.fetcher.domain.SearchResult;
import uk.tanton.legislation.fetcher.domain.legislation.ContentsPart;
import uk.tanton.legislation.fetcher.domain.legislation.Part;
import uk.tanton.legislation.fetcher.domain.searchresult.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class LegislationClient {

    private static final String BASE_URL = "http://www.legislation.gov.uk/";//1990-2000";
    private static final String URL_SUFFIX = "/data.feed";


    private final HttpClient httpClient;

    public LegislationClient(final HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    public SearchResult search(final int startYear, final int endYear, int page) throws IOException, JAXBException {
        final String url = BASE_URL + startYear + "-" + endYear + URL_SUFFIX + "?page=" + page;
        JAXBContext jaxbContext = JAXBContext.newInstance(SearchResult.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "application/xml");
        final HttpResponse httpResponse = makeGetRequest(httpGet);
        final SearchResult result = (SearchResult) unmarshaller.unmarshal(httpResponse.getEntity().getContent());
        httpGet.releaseConnection();
        return result;
    }

    public SearchResult search(final int startYear, final int endYear) throws IOException, JAXBException {
        return search(startYear, endYear, 1);
    }


    public List<Entry> getAllEntries(final int startYear, final int endYear) throws IOException, JAXBException {
        final SearchResult firstPage = search(startYear, endYear);
        final int totalPages = firstPage.getMorePages();

        final List<Entry> allEntries = new ArrayList<Entry>();
        allEntries.addAll(firstPage.getEntry());

        for (int i = 2; i <= totalPages; i++) {
            allEntries.addAll(search(startYear, endYear, i).getEntry());
        }
        return allEntries;
    }


    public Legislation getEntryInfo(final Entry entry) throws IOException, JAXBException {
        final HttpGet httpGet = new HttpGet(entry.getId() + "/data.xml");
        final HttpResponse httpResponse = makeGetRequest(httpGet);
        JAXBContext jaxbContext = JAXBContext.newInstance(Legislation.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        final String responseString =
//                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                        EntityUtils.toString(httpResponse.getEntity());
//        System.out.println(responseString);
//        return (Legislation) unmarshaller.unmarshal(httpResponse.getEntity().getContent());

        JAXBElement<Legislation> root = unmarshaller.unmarshal(new StreamSource(new InputStreamReader(httpResponse.getEntity().getContent())), Legislation.class);
        httpGet.releaseConnection();
        return root.getValue();


//        return (Legislation) unmarshaller.unmarshal(stringReader);
    }

    public List<Part> fetchAllParts(final Legislation legislation) throws IOException, JAXBException {
        final List<Part> parts = new ArrayList<>();
        JAXBContext jaxbContext = JAXBContext.newInstance(Legislation.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        for (ContentsPart contentsPart : legislation.getContents().getContentsParts()) {
            final HttpGet httpGet = new HttpGet(contentsPart.getDocumentURI() + "/data.xml");
            final HttpResponse httpResponse = makeGetRequest(httpGet);
            final String responseString = EntityUtils.toString(httpResponse.getEntity()).replace("“", "");

            JAXBElement<Legislation> root = unmarshaller.unmarshal(new StreamSource(new StringReader(responseString)), Legislation.class);
            final Legislation value = root.getValue();
            parts.add(root.getValue().getPrimary().getBody().getPart());
//            TODO: do something
            httpGet.releaseConnection();
        }

        return parts;
    }


    private HttpResponse makeGetRequest(final HttpUriRequest request) throws IOException {
        return makeGetRequest(request, 5, 1000);
    }

    private HttpResponse makeGetRequest(final HttpUriRequest request, final int noOfTries, final int backoff) throws IOException {
        if (noOfTries < 0) {
            throw new RuntimeException("Exceeded max no of re tries");
        }

        try {
            System.out.println("hitting (" + noOfTries + "): " + request);
            final HttpResponse execute = httpClient.execute(request);
            if (execute.getStatusLine().getStatusCode() == 200) {
                return execute;
            } else {
                Thread.sleep(backoff);
                return makeGetRequest(request, noOfTries - 1, backoff * 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return makeGetRequest(request, noOfTries - 1, backoff * 2);
        } catch (InterruptedException e) {
            throw new RuntimeException("this should never happen", e);
        }
    }


}
