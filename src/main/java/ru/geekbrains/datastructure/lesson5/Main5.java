package ru.geekbrains.datastructure.lesson5;

public class Main5 {

    public static void main(String[] args) {
//        countDownLoop(5);
        countDown(5);
    }

    private static void countDown(int n) {
        if (n > 0) {
            System.out.println(n);
            countDown(--n);
        }
    }

    private static void countDownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            n--;
        }
    }
}
