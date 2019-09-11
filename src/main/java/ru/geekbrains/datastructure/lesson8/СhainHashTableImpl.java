package ru.geekbrains.datastructure.lesson8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class СhainHashTableImpl<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DOUBLE_HASH_CONST = 5;

    private List <Node<K,V>>[] data;
    private int size;

    private int maxSize;

    @SuppressWarnings("unchecked")
    public СhainHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new List[maxSize * 2];
    }

    private int hashFunc(K key) {
        return DOUBLE_HASH_CONST - (key.hashCode() % DOUBLE_HASH_CONST);
    }

    @Override
    public boolean put(K key, V value) {

        if (isFull()) {
            //rehash()
            return false;
        }

        int index = hashFunc(key);

        if (data[index]!=null){
            while (!data[index].isEmpty()) {
                for (Object node:data[index]) {
                    Node n = (Node) node;
                    if (n.key.equals(key)) {
                        n.setValue(value);
                    } else {
                        data[index].add(new Node<>(key, value));
                        size++;
                    }
                    return true;
                }

                index += getStep(key);
                index %= data.length;//if (index == data.length) index = 0;
            }
        }

        data[index] = new LinkedList<Node<K,V>>();
        data[index].add(new Node<K,V>(key, value));
        size++;

        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        return getEntry(data[index],key);
    }

    private V getEntry(List list,K key){
        for (Object node:list) {
            Node n = (Node) node;
            if (n.key.equals(key))
                return (V) n.getValue();
        }
        return null;
    }


    /**
     * мой пробный вариант через Optional
     *   @Override
     *     public V get(K key) {
     *         int index = hashFunc(key);
     *         return getEntry(data[index],key)
     *                 .map(Node::getValue)
     *                 .orElse(null);
     *         //get(data[index],key);
     *     }
     *
     *     private Optional<Node<K, V>> getEntry(List list,K key){
     *         for (Object node:list) {
     *             Node n = (Node) node;
     *             if (n.key.equals(key))
     *                 return Optional.empty();//(V) n.getValue();
     *         }
     *         return null;
     *     }
     */

//    @Override
//    public V get(K key) {
//        return getEntry(key)
//                .map(Node::getValue)
//                .orElse(null);
//
//        //Entry entry = getEntry(key);
//        //return entry != null ? entry.value : null;
//    }

//    private Optional<Node<K, V>> getEntry(K key) {
//        int index = indexOf(key);
//        if (index != -1) {
//            return Optional.of(data[index]);
//        }
//
//        return Optional.empty();
//    }
//
//    private int indexOf(K key) {
//        int index = hashFunc(key);
//        while (data[index] != null) {
//            Node current = data[index];
//            if (current.getKey().equals(key)) {
//                return index;
//            }
//            index += getStep(key);
//            index %= data.length;
//        }
//
//        return -1;
//    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        if (contains(key)){
            List list = data[hashFunc(key)];
            for (Object node:list) {
                Node n = (Node) node;
                if (n.key.equals(key)){
                    V result = (V) n.getValue();
                    list.remove(n);
                    size--;
                    return result;
                }
            }
        }
        return null;
    }

//    @Override
//    public V remove(K key) {
//        int index = indexOf(key);
//        if (index == -1) {
//            return null;
//        }
//
//        V result = data[index].getValue();
//        data[index] = null;
//        size--;
//        return result;
//    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void display() {
        int count = 0;
        System.out.println("---------");
        for (int index = 0; index < data.length; index++) {

            if (data[index]!= null){
                Iterator <Node<K,V>> itr = data[index].iterator();
                while (itr.hasNext()){
                    System.out.printf("%d, %d = [%s]", index, count++, itr.next());
                    System.out.println();
                }
            } else {
                System.out.printf("%d, %d = [%s]", index, count++, data[index]);
                System.out.println();
            }
        }
        System.out.println("---------");
    }

    protected int getStep(K key) {
        return hashFunc(key);
    }
}
