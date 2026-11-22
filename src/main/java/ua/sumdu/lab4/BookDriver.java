package ua.sumdu.lab4;

public class BookDriver {
    private static final int BOOK_COUNT = 5;

    public static void main(String[] args) {
        Book[] books = new Book[BOOK_COUNT];
        books[0] = new Book("Kobzar", "Taras Shevchenko", 1840, 114, 250.00);
        books[1] = new Book("Clean Code", "Robert C. Martin", 2008, 464, 899.50);
        books[2] = new Book("Effective Java", "Joshua Bloch", 2018, 412, 1200.00);
        books[3] = new Book("1984", "George Orwell", 1949, 328, 320.00);
        books[4] = new Book("Kobzar", "Taras Shevchenko", 1840, 114, 250.00);

        printBooks(books);

        System.out.println();
        System.out.println("books[0].equals(books[4]): " + books[0].equals(books[4]));
        System.out.println("books[0].equals(books[1]): " + books[0].equals(books[1]));
    }

    private static void printBooks(Book[] books) {
        System.out.println("Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
    }
}
