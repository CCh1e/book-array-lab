package ua.sumdu.lab4;

import java.time.Year;
import java.util.Scanner;

public class BookDriver {
    private static final int BOOK_COUNT = 5;
    private static final int PRESET_COUNT = 3;

    public static void main(String[] args) {
        Book[] books = new Book[BOOK_COUNT];
        books[0] = new Book("Kobzar", "Taras Shevchenko", 1840, 114, 250.00);
        books[1] = new Book("Clean Code", "Robert C. Martin", 2008, 464, 899.50);
        books[2] = new Book("Effective Java", "Joshua Bloch", 2018, 412, 1200.00);

        Scanner scanner = new Scanner(System.in);
        for (int i = PRESET_COUNT; i < BOOK_COUNT; i++) {
            System.out.println("Enter data for book #" + (i + 1) + ":");
            books[i] = readBook(scanner);
            System.out.println();
        }

        printBooks(books);

        Book copy = new Book("Kobzar", "Taras Shevchenko", 1840, 114, 250.00);
        System.out.println();
        System.out.println("books[0].equals(copy of books[0]): " + books[0].equals(copy));
        System.out.println("books[0].equals(books[1]): " + books[0].equals(books[1]));
    }

    private static Book readBook(Scanner scanner) {
        String title = readText(scanner, "  Title: ");
        String author = readText(scanner, "  Author: ");
        int year = readInt(scanner, "  Year: ", 1, Year.now().getValue());
        int pages = readInt(scanner, "  Pages: ", 1, 100_000);
        double price = readPrice(scanner, "  Price: ");
        return new Book(title, author, year, pages, price);
    }

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println();
            System.out.println("Input ended unexpectedly.");
            System.exit(1);
        }
        return scanner.nextLine().trim();
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            String value = readLine(scanner, prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("  Value cannot be empty, try again.");
        }
    }

    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            String value = readLine(scanner, prompt);
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("  Enter a whole number from " + min + " to " + max + ".");
        }
    }

    private static double readPrice(Scanner scanner, String prompt) {
        while (true) {
            String value = readLine(scanner, prompt).replace(',', '.');
            try {
                double number = Double.parseDouble(value);
                if (number >= 0 && Double.isFinite(number)) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("  Enter a non-negative number, e.g. 199.99.");
        }
    }

    private static void printBooks(Book[] books) {
        System.out.println("Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
}
