/**
 * @author agung 1972050
 */
import java.util.Arrays;
import java.util.Scanner;


public class BookList {
    private Book[] books;

    public BookList() {
    }

    public void addBook(Book book) {
        if (books == null) {
            books = new Book[0];

        }
        books = Arrays.copyOf(books, books.length + 1);
        String isbn, title, author;
        Scanner sc = new Scanner(System.in);
        System.out.print("New ISBN: ");
        isbn = sc.nextLine();
        System.out.print("New Judul Buku: ");
        title = sc.nextLine();
        System.out.print("New Penulis: ");
        author = sc.nextLine();
        books[books.length - 1] = new Book(isbn, title, author);

    }

    public Book[] searchBook(String isbn){
        Book[] dicari=new Book[1];
        if (books==null){
            return null;
        }
        for (int i=0;i<books.length;i++) {
            if (isbn.equals(books[i].getIsbn())){
                dicari[0]=books[i];
            }
        }
        return dicari;
    }
    public void showAllBook(){
        if (books==null){
            System.out.println("Masih belum tedapat buku di list");
            System.out.println("Masukan 2 dichoice untuk menginput buku");
        }
        else {
            String[][] table = new String[3][books.length];
            int [] mx=new int[3];
            for (int i = 0; i < books.length; i++) {
                table[0][i]=books[i].getIsbn();
                table[1][i]=books[i].getTitle();
                table[2][i]=books[i].getAuthor();
            }
            mx[0]=4;
            mx[1]=5;
            mx[2]=6;
            for (int i = 0; i < books.length; i++) {
                if (mx[0]<table[0][i].length()){
                    mx[0]=table[0][i].length();
                }
                if (mx[1]<table[1][i].length()){
                    mx[1]=table[1][i].length();
                }
                if (mx[2]<table[2][i].length()){
                    mx[2]=table[2][i].length();
                }
            }

            System.out.print("ISBN");
            for (int j=0;j<=mx[0]-4;j++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("Judul");
            for (int j=0;j<=mx[1]-5;j++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("Author");
            for (int j=0;j<=mx[2]-6;j++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
            for (int i = 0; i < books.length; i++) {
                System.out.print(books[i].getIsbn());
                for (int j=0;j<=mx[0]-books[i].getIsbn().length();j++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(books[i].getTitle());
                for (int j=0;j<=mx[1]-books[i].getTitle().length();j++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(books[i].getAuthor());
                for (int j=0;j<=mx[2]-books[i].getAuthor().length();j++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println();
            }
        }
    }
}
