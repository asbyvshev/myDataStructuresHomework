package ru.geekbrains.datastructure.lesson4.iterator;

import ru.geekbrains.datastructure.lesson4.linkedlist.LinkedList;
import ru.geekbrains.datastructure.lesson4.linkedlist.SimpleLinkedList;

public class homework4 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);

        for (Integer value: linkedList) {
            System.out.println(value);
        }
    }
}
