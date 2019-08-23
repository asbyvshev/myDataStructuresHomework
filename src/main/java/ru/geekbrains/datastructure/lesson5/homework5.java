package ru.geekbrains.datastructure.lesson5;

public class homework5 {

    public static void main(String[] args) {
        int nuber = 3;
        int extent = 2;
        System.out.println(myExponentiation(nuber,extent));
    }

    private static int myExponentiation(int nuber, int extent) {
        if (nuber == 0){ return 0; }
        if (extent < 1){ return 1; }
        if (extent == 1){ return nuber; }
        return nuber * myExponentiation(nuber,extent - 1);
    }


}
