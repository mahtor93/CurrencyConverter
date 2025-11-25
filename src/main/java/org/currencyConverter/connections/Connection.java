package org.currencyConverter.connections;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {



    public static HttpResponse<String> request(String divisaFrom, String divisaTo ) throws IOException {
        try {

            HttpClient client = HttpClient.newBuilder()
                    .build();

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(
                            String.format("https://api.fastforex.io/fetch-one?from=%s&to=%s",divisaFrom,divisaTo)
                    ))
                    .header("Authorization","Bearer "+"655eca4e59-1d42f68b5b-t68w5e")
                    .GET()
                    .build();

            return client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            System.out.println("===> Error al realizar petición: \n"+e.getMessage());
            return null;
        }
    }

}
