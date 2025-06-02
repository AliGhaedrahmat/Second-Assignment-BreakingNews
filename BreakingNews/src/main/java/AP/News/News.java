package AP.News;

import AP.Utils.Console;

public class News {
    private String title;
    private String description;
    private String sourceName;
    private String author;
    private String url;
    private String publishedAt;

    public News(String title, String description, String sourceName, String author, String url, String publishedAt) {
        this.title = title;
        this.description = description;
        this.sourceName = sourceName;
        this.author = author;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    public void displayNews() {
        Console.print("📰 Title: " + title, Console.Color.CYAN);
        Console.print("📜 Description: " + description, Console.Color.WHITE);
        Console.print("✍️ Author: " + (author.isEmpty() ? "Unknown" : author), Console.Color.WHITE);
        Console.print("🌐 Source: " + sourceName, Console.Color.WHITE);
        Console.print("🕒 Published At: " + publishedAt, Console.Color.WHITE);
        Console.print("🔗 URL: " + url, Console.Color.BLUE);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "📰 " + title + "\n" +
                "📜 " + description + "\n" +
                "✍️ " + (author.isEmpty() ? "Unknown" : author) + "\n" +
                "🌐 " + sourceName + "\n" +
                "🕒 " + publishedAt + "\n" +
                "🔗 " + url;
    }
}
