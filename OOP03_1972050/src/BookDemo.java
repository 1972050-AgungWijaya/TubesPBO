/**
 * @author agung 1972050
 */
import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args) {
        int pil;
        String isbn;
        Book book=new Book();
        BookList bl=new BookList();
        do{
            System.out.println("=======================================");
            System.out.printf("%28s","Library Aplication");
            System.out.println();
            System.out.println("=======================================");
            System.out.println("1. Show all book");
            System.out.println("2. Add new buku");
            System.out.println("3. Search Book");
            System.out.println("0. Exit");
            System.out.println("=======================================");
            System.out.print("Choice :");
            Scanner sc=new Scanner(System.in);
            pil=sc.nextInt();
            if (pil==1) {
                bl.showAllBook();
            }
            else if (pil==2){
                bl.addBook(book);
            }
            else if (pil==3){
                Book []srcBk=new Book[1];
                System.out.print("Cari pakai isbn:");
                isbn=sc.next();
                srcBk=bl.searchBook(isbn);
                if (srcBk==null) {
                    System.out.println("Buku belum terdapat di list");
                }
                else {
                    if(srcBk[0]==null){
                        System.out.println("Buku belum terdapat di list");
                    }
                    else {
                        System.out.println("Buku ketemu");
                        System.out.print("Kode ISBN: ");
                        System.out.println(srcBk[0].getIsbn());
                        System.out.print("Judul: ");
                        System.out.println(srcBk[0].getTitle());
                        System.out.print("Author: ");
                        System.out.println(srcBk[0].getAuthor());
                    }
                }

            }
            else if (pil==0){
            }
            else{
                System.out.println("Wrong menu");
            }
        }while(pil!=0);
    }
}
