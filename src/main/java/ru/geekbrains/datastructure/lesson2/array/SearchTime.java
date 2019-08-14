package ru.geekbrains.datastructure.lesson2.array;

import java.util.Random;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchTime {
    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) {

        Array arr1 = new ArrayImpl();
        Array arr2 = new ArrayImpl();
        Array arr3 = new ArrayImpl();

        randomInitialize(arr1,arr2,arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
    }
    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }
}
