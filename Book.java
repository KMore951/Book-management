import java.util.ArrayList;
import java.util.Arrays;

public class Book {

    public static ArrayList<Book> bookList = new ArrayList<>();
    private int bookId;
    private String bookName;
    private String description;
    private String[] genre;
    private int pages;
    private int price;

    public Book(int bookId, String bookName, String description, String[] genre, int pages, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.genre = genre;
        this.pages = pages;
        this.price = price;

        System.out.println("Book created successfully.");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //function to display a books properties
    public void displayBook() {
        System.out.println();
        System.out.println("Book id: " + this.getBookId());
        System.out.println("Book Name: " + this.getBookName());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Genres: " + Arrays.toString(this.getGenre()));
        System.out.println("Number of Pages: " + this.getPages());
        System.out.println("Price: " + this.getPrice());
        System.out.println();
    }

    //add book to list
    public static void addBookToList(Book book) {
        bookList.add(book);
        System.out.println("Book with id: " + book.getBookId() + " added to list.");
    }

    //overloaded functions to update books
    public void updateBook(String newName) {
        this.setBookName(newName);
        System.out.println("Updated book name for book with id: " + this.getBookId());
    }

    public void updateBook(String temp, String description) {
        this.setDescription(description);
        System.out.println("Updated description for book with id: " + this.getBookId());
    }

    public void updateBook(String[] genre) {
        this.setGenre(genre);
        System.out.println("Updated genres for book with id: " + this.getBookId());
    }

    public void updateBook(int pages) {
        this.setPages(pages);
        System.out.println("Updated number of pages for book with id: " + this.getBookId());
    }

    public void updateBook(int temp, int price) {
        this.setPrice(price);
        System.out.println("Updated price for book with id: " + this.getBookId());
    }

    //function to delete a book
    public static void deleteBookFromList(int bookId) {
        boolean isPresent = false;
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                isPresent = true;
                System.out.println("Book deleted successfully.");
                break;
            }
        }

        if (!isPresent) {
            System.out.println("Book doesn't exist.");
        }
    }

    //function to retrieve a book
    public static Book findBookInList(int bookId) {
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }

        System.out.println("Book not found.");
        return null;
    }

    // function to display all books
    public static void displayAllBooksInList() {
        for (Book book : bookList) {
            book.displayBook();
        }
    }

}
