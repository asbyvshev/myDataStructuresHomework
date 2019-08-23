package ru.geekbrains.datastructure.lesson5;

public class homework5 {

    public static void main(String[] args) {
        int number = 3;
        int extent = 2;
        System.out.println(myExponentiation(number,extent));
    }

    private static int myExponentiation(int number, int extent) {
        if (number == 0){ return 0; }
        if (extent < 1){ return 1; }
        if (extent == 1){ return number; }
        return number * myExponentiation(number,extent - 1);
    }


}
