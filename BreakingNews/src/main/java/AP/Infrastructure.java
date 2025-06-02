package AP;

import java.util.ArrayList;

import AP.News.News;
import AP.News.NewsAPIClient;
import AP.News.NewsParser;
import AP.Utils.ConsoleHelper;

public class Infrastructure {

    private final NewsAPIClient apiClient;
    private ArrayList<News> newsList = new ArrayList<>();

    public Infrastructure(String apiKey) {
        this.apiClient = new NewsAPIClient(apiKey);
        fetchAndDisplayTopNews();
    }

    private void fetchAndDisplayTopNews() {
        String json = apiClient.fetchTopHeadlines();
        newsList = NewsParser.parseNewsList(json);

        if (newsList.isEmpty()) return;

        ConsoleHelper.printNewsList(newsList);

        int choice = ConsoleHelper.promptUserChoice(newsList);
        if (choice >= 0) {
            newsList.get(choice).displayNews();
        }
    }

    public ArrayList<News> fetchNews(String query) {
        String json = apiClient.fetchEverything(query);
        ArrayList<News> results = NewsParser.parseNewsList(json);

        ConsoleHelper.printNewsList(results);

        return results;
    }
}
