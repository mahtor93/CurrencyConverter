package org.currencyConverter.connections;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {
    protected static HttpResponse<String> request(String uri, String query) throws IOException {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .build();

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(
                            String.format("%s/%s", uri, query)
                    ))
                    .build();

            return client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            System.out.println("===> Error al realizar petición: \n"+e.getMessage());
            return null;
        }
    }

}
