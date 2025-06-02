package AP;

import AP.Utils.Console;

public class Main {
    public static void main(String[] args) {
        Console.clear();
        Console.print("-- News API -- ");
        String apiKey =  "fa90611cb9894bebbf02887180d6e762";
        Infrastructure infrastructure = new Infrastructure(apiKey);
    }
}