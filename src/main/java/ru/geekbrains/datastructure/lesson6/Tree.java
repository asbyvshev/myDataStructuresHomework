package ru.geekbrains.datastructure.lesson6;

import ru.geekbrains.datastructure.lesson2.ICollection;

public interface Tree<E> extends ICollection, Iterable<E> {

    enum TraverseMode{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(E value);

    boolean add(E value);

    boolean remove(E value);

    void display();

    boolean isBalanced();

    int height();

    void traverse(TraverseMode mode);
}
