package AP.News;

import AP.Utils.Console;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewsAPIClient {

    private final String apiKey;
    private final HttpClient client;

    public NewsAPIClient(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
    }

    public String fetchTopHeadlines() {
        String url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + apiKey;
        return fetchFromUrl(url);
    }

    public String fetchEverything(String query) {
        String url = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=" + apiKey;
        return fetchFromUrl(url);
    }

    private String fetchFromUrl(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                Console.print("❌ HTTP Error: " + response.statusCode(), Console.Color.RED);
                return null;
            }
        } catch (IOException | InterruptedException e) {
            Console.print("❌ Network Error: " + e.getMessage(), Console.Color.RED);
            return null;
        }
    }
}
