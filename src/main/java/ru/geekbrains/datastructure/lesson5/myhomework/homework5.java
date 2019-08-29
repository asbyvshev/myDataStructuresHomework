package ru.geekbrains.datastructure.lesson5.myhomework;

public class homework5 {

    public static void main(String[] args) {

        int number = 3;
        int extent = 2;
        System.out.println("____tast1____ \n");
        System.out.println(myExponentiation(number,extent));
        System.out.println("____tast2____ \n");


        thing book = new thing("Книга",1,600);
        thing binoculars = new thing("Бинокль",2,5000);
        thing kit = new thing("Аптечка",4,1500);
        thing laptop = new thing("Ноутбук",2,40000);
        thing pot = new thing("Котелок",1,500);

        backpack bp = new backpack(binoculars,book,kit,laptop,pot);
        bp.stack();


    }

    private static int myExponentiation(int number, int extent) {

        if (number == 0){
            if (extent > 0) {
                return 0;
            } else {
                throw new IllegalArgumentException("Некорректное значене степени " + extent
                        + "долно быть положительным!");
            }
        }
        if (extent < 1){ return 1; }
        if (extent == 1){ return number; }

        return number * myExponentiation(number,extent - 1);
    }
}

