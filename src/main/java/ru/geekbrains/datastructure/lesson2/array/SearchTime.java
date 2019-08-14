package ru.geekbrains.datastructure.lesson2.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchTime {
    private static final int ARRAY_CAPACITY = 10_000;
    private static final int MAX_VALUE = 10_000;

    public static void main(String[] args) throws InterruptedException {

        Array arr1 = new ArrayImpl();
        Array arr2 = new ArrayImpl();
        Array arr3 = new ArrayImpl();

        randomInitialize(arr1,arr2,arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(measureTime(arr1::sortBubble, "Sort Bubble"));
        tasks.add(measureTime(arr2::sortSelect, "Sort Select"));
        tasks.add(measureTime(arr3::sortInsert, "Sort Insert"));

        for (Runnable task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
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
    private static Runnable measureTime(Runnable action, String actionName) {
       return new Runnable() {
            @Override
            public void run() {
                long startTime = System.nanoTime();
                action.run();
                long finishTime = System.nanoTime();
                long duration = finishTime - startTime;

                System.out.println(String.format("%s took time: %d micros.",
                        actionName,
                        TimeUnit.NANOSECONDS.toMicros(duration)));
            }
        };
    }
}
