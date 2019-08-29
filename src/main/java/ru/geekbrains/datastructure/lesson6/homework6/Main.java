package ru.geekbrains.datastructure.lesson6.homework6;


import ru.geekbrains.datastructure.lesson6.Tree;
import ru.geekbrains.datastructure.lesson6.TreeImpl;

public class Main {
    public static void main(String[] args) {
        int balanced = 0;
        int noBalanced = 0;

        for (int i = 0; i < 20; i++) {
            if (createTree()) {
                balanced++;
            } else {
                noBalanced++;
            }
        }

        System.out.printf("Сбаланисрованных - %d, Несбаланисрованных - %d",balanced,noBalanced);
    }

    private static boolean createTree() {

        int max = 20;
        int min = -20;

        Tree<Integer> tree = new TreeImpl<>();

        while (tree.)

            int node = (int) (Math.random()*((max - min)+ 1)) + min;
            tree.add(node);


    }
}
