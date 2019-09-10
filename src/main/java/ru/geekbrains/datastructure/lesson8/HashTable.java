package ru.geekbrains.datastructure.lesson8;

import ru.geekbrains.datastructure.lesson2.ICollection;

public interface HashTable<K, V> extends ICollection {

    boolean put(K key, V value);

    V get(K key);

    boolean contains(K key);

    V remove(K key);

    void display();


    interface Entry<K, V> {
        K getKey();
        void setKey(K key);

        V getValue();
        void setValue(V value);
    }


}
