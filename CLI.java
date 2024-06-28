import java.util.Scanner;

public class CLI {
    private URLShortener urlShortener;

    public CLI() {
        urlShortener = new URLShortener();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command (shorten, expand, or quit):");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                break;
            } else if (command.equals("shorten")) {
                System.out.println("Enter a long URL:");
                String longURL = scanner.nextLine();
                String shortURL = urlShortener.shortenURL(longURL);
                System.out.println("Short URL: " + shortURL);
            } else if (command.equals("expand")) {
                System.out.println("Enter a short URL:");
                String shortURL = scanner.nextLine();
                try {
                    String longURL = urlShortener.expandURL(shortURL);
                    System.out.println("Long URL: " + longURL);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid short URL");
                }
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.run();
    }
}