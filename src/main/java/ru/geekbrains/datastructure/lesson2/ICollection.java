package ru.geekbrains.datastructure.lesson2;

public interface ICollection {

    boolean isEmpty();

    int size();

    default boolean isFull() {
        return false;
    }
}
