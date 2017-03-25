package uk.tanton.legislation.fetcher;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import uk.tanton.legislation.fetcher.domain.Legislation;
import uk.tanton.legislation.fetcher.domain.SearchResult;
import uk.tanton.legislation.fetcher.domain.legislation.Part;
import uk.tanton.legislation.fetcher.domain.searchresult.Entry;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {

        final PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(3);
        final HttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("legislation-fetcher")
//                .setConnectionManager(connManager)
                .setDefaultRequestConfig(RequestConfig.custom()
                                .setConnectionRequestTimeout(10000)
                                .setConnectTimeout(10000)
                                .setSocketTimeout(10000)
                                .build()
                )
//                .setProxy(new HttpHost("www-cache.reith.bbc.co.uk", 80))
                .build();

        final LegislationClient legislationClient = new LegislationClient(httpClient);

        final SearchResult search = legislationClient.search(1990, 2000);


//        final Legislation entryInfo = legislationClient.getEntryInfo(search.getEntry().get(search.getEntry().size() - 1));
//
//        final List<Part> parts = legislationClient.fetchAllParts(entryInfo);
//
//        System.out.println(LegislationUtils.convertPartsToString(parts));

        for (Entry entry : search.getEntry()) {
            final Legislation entryInfo = legislationClient.getEntryInfo(entry);

            final List<Part> parts = legislationClient.fetchAllParts(entryInfo);
            File dir = new File("output");
            if (!dir.isDirectory()) {
                dir.mkdir();
            }
            FileWriter fw = new FileWriter(new File("output/" + entry.getTitle() + ".txt"));
            fw.append(LegislationUtils.convertPartsToString(parts));
            fw.flush();
            fw.close();

        }

    }
}
