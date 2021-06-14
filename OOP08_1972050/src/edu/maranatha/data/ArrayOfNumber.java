package edu.maranatha.data;

import edu.maranatha.exceptions.ArrayException;

import java.util.Arrays;


public class ArrayOfNumber {
    private Integer[] number;
    public void constructArray() throws ArrayException {
        if (number==null){
            number=new Integer[0];
        }
        else {
            throw new ArrayException("Array telah dibuat");
        }

    }
    public void increaseArrayIndex() throws ArrayException {
        if (number==null){
            throw new ArrayException("Array belum dibuat");
        }
        else {
            number = Arrays.copyOf(number, number.length + 1);
            System.out.println("Array berhasil ditambahkan");
        }

    }
    public void addValueToArray(int index,int value) throws ArrayException {
        if (number==null ){
            throw new ArrayException("Array belum dibuat");
        }
        else if (number.length-1<index  ){
            throw new ArrayException("Index lebih besar dari panjang array");
        }
        else{
            number[index]=value;
        }
    }
    public void showArray() throws ArrayException {
        if (number==null){
            throw new ArrayException("Array belum dibuat");
        }
        else {
            System.out.print("Isian array: [");
            for (int i=0;i<number.length;i++) {
                if (i<number.length-1) {
                    System.out.print(number[i].toString() + ", ");
                }
                else{
                    System.out.print(number[i].toString() + "]");
                }
            }
            System.out.println();
        }
    }
}
