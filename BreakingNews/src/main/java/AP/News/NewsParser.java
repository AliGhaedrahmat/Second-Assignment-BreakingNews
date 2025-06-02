package AP.News;

import AP.Utils.Console;
import com.google.gson.*;

import java.util.ArrayList;

public class NewsParser {

    public static ArrayList<News> parseNewsList(String json) {
        ArrayList<News> newsList = new ArrayList<>();
        if (json == null) return newsList;

        try {
            JsonObject root = JsonParser.parseString(json).getAsJsonObject();

            if (root.has("status") && root.get("status").getAsString().equals("error")) {
                Console.print("❌ Error: " + root.get("message").getAsString(), Console.Color.RED);
                return newsList;
            }

            JsonArray articles = root.getAsJsonArray("articles");

            for (JsonElement elem : articles) {
                JsonObject obj = elem.getAsJsonObject();

                String title = obj.get("title").getAsString();
                String description = obj.get("description").isJsonNull() ? "" : obj.get("description").getAsString();
                String sourceName = obj.getAsJsonObject("source").get("name").getAsString();
                String author = obj.get("author").isJsonNull() ? "" : obj.get("author").getAsString();
                String url = obj.get("url").getAsString();
                String publishedAt = obj.get("publishedAt").getAsString();

                newsList.add(new News(title, description, sourceName, author, url, publishedAt));
            }

        } catch (JsonSyntaxException e) {
            Console.print("❌ JSON Parsing Error: " + e.getMessage(), Console.Color.RED);
        } catch (Exception e) {
            Console.print("❌ Unexpected Error: " + e.getMessage(), Console.Color.RED);
        }
        return newsList;
    }
}
