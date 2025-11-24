package org.currencyConverter.connections;

import org.currencyConverter.Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Connection {



    public static HttpResponse<String> request(String query) throws IOException {
        try {

            Properties props = new Properties();
            try (InputStream is = Main.class.getResourceAsStream("/config.ex.properties")) {
                props.load(is);
            } catch (Exception ex){
                System.out.println(ex);
            }

            String API_KEY = props.getProperty("API_KEY");

            HttpClient client = HttpClient.newBuilder()
                    .build();

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(
                            String.format("https://api.fastforex.io/%s",query)
                    ))
                    .header("Authorization","Bearer "+API_KEY)
                    .GET()
                    .build();

            return client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            System.out.println("===> Error al realizar petición: \n"+e.getMessage());
            return null;
        }
    }

}
