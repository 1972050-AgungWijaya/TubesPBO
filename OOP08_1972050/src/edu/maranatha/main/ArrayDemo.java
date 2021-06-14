package edu.maranatha.main;

import edu.maranatha.data.ArrayOfNumber;
import edu.maranatha.exceptions.ArrayException;

import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) throws ArrayException {
        int pil;
        ArrayOfNumber array=new ArrayOfNumber();
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("=======================================");
            System.out.println("1. Make array");
            System.out.println("2. Add length to array");
            System.out.println("3. Insert new data to array");
            System.out.println("4. Show array");
            System.out.println("5. Exit");
            System.out.print("Choice :");
            pil=sc.nextInt();
            if (pil==1) {
                try {
                    array.constructArray();
                }catch(ArrayException e){
                    System.out.println(e.getMessage());
                }
            }
            else if (pil==2){
                try {
                    array.increaseArrayIndex();
                }catch(ArrayException e){
                    System.out.println(e.getMessage());
                }
            }
            else if (pil==3){
                try {
                    try{
                        System.out.print("Index = ");
                        int i=Integer.parseInt(sc.next());
                        System.out.print("Number = ");
                        int n=Integer.parseInt(sc.next());
                        array.addValueToArray(i,n);
                    }catch (NumberFormatException e ){
                        System.out.println("Pastikan input merupakan angka");
                    }
                }catch(ArrayException e){
                    System.out.println(e.getMessage());
                }
            }
            else if (pil==4){
                try {
                    array.showArray();
                }catch(ArrayException e){
                    System.out.println(e.getMessage());
                }
            }
            else if(pil==5){
            }
        }while(pil!=5);
    }
}
