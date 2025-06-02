package AP.Utils;

import AP.News.News;

import java.util.ArrayList;

public class ConsoleHelper {

    public static void printNewsList(ArrayList<News> newsList) {
        for (int i = 0; i < newsList.size(); i++) {
            Console.commandLabel(newsList.get(i).getTitle(), i + 1);
        }
    }

    public static int promptUserChoice(ArrayList<News> newsList) {
        String input = Console.getInputBox(
                "Choose a news item to view details:",
                newsList.stream().map(News::getTitle).toArray(String[]::new),
                "Your choice"
        );

        try {
            int choice = Integer.parseInt(input.trim());
            if (choice < 1 || choice > newsList.size()) {
                Console.print("❌ Invalid choice!", Console.Color.RED);
                return -1;
            }
            return choice - 1;
        } catch (NumberFormatException e) {
            Console.print("❌ Invalid input!", Console.Color.RED);
            return -1;
        }
    }
}
