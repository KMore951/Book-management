import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Enter your choice: ");
            System.out.println();
            System.out.println("1) Display all books in list.");
            System.out.println("2) Create a new book and add to list.");
            System.out.println("3) Retrieve a book by its book ID.");
            System.out.println("4) Update a book.");
            System.out.println("5) Delete a book from the list.");
            System.out.println("6) Exit.");
            System.out.println();

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    Book.displayAllBooksInList();
                    if(Book.bookList.isEmpty()){
                        System.out.println("List is empty.");
                    }
                    System.out.println();
                    continue;

                case 2:
                    System.out.println("Enter book ID:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter book name:");
                    String name = sc.nextLine();

                    System.out.println("Enter book description:");
                    String desc = sc.nextLine();

                    System.out.println("Enter book genres separated by spaces:");
                    String gens = sc.nextLine();
                    String[] genres = gens.split(" ");

                    System.out.println("Enter number of pages in book:");
                    int pages = sc.nextInt();

                    System.out.println("Enter price:");
                    int price = sc.nextInt();

                    Book newBook = new Book(id, name, desc, genres, pages, price);
                    Book.addBookToList(newBook);
                    continue;

                case 3:
                    System.out.println("Enter book id:");
                    int id2 = sc.nextInt();
                    Book retrievdBook = Book.findBookInList(id2);
                    if (retrievdBook == null) {
                        System.out.println("Book doesnt exist from switch case 3.");
                    } else {
                        retrievdBook.displayBook();
                    }

                    continue;

                case 4:
                    System.out.println("Enter ID of book to be updated:");
                    int id3 = sc.nextInt();
                    Book toBeUpdated = Book.findBookInList(id3);
                    if (toBeUpdated == null) {
                        System.out.println("Book doesnt exist from switch case 3.");
                    } else {
                        System.out.println("Choose what to update:");
                        System.out.println();
                        System.out.println("1) Name");
                        System.out.println("2) Description");
                        System.out.println("3) Genres");
                        System.out.println("4) Pages");
                        System.out.println("5) Price");

                        int choice = sc.nextInt();

                        nestedBookUpdate(toBeUpdated, choice);
                        continue;
                    }

                case 5:
                    System.out.println("Enter ID of book to be deleted:");
                    int id4 = sc.nextInt();
                    Book.deleteBookFromList(id4);
                    continue;

                case 6:
                    System.out.println("Thank you.");
                    keepRunning = false;
                    continue;

                default:
                    System.out.println("Please enter a valid choice.");
                    continue;
            }

//            break;
        }


    }

    public static void nestedBookUpdate(Book toBeUpdated, int choice) {
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Enter new name:");
                String name = sc.nextLine();
                toBeUpdated.updateBook(name);
                break;

            case 2:
                System.out.println("Enter new description:");
                String desc = sc.nextLine();
                toBeUpdated.updateBook(null, desc);
                break;

            case 3:
                System.out.println("Enter book genres separated by spaces:");
                String gens = sc.nextLine();
                String[] genres = gens.split(" ");
                toBeUpdated.updateBook(genres);
                break;

            case 4:
                System.out.println("Enter number of pages:");
                int pages = sc.nextInt();
                toBeUpdated.updateBook(pages);
                break;

            case 5:
                System.out.println("Enter price:");
                int price = sc.nextInt();
                toBeUpdated.updateBook(0, price);
                break;

            default:
                System.out.println("Please make a valid choice.");
                break;
        }
    }
}
