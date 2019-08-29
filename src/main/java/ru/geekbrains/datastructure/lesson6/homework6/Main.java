package ru.geekbrains.datastructure.lesson6.homework6;


import ru.geekbrains.datastructure.lesson6.Tree;
import ru.geekbrains.datastructure.lesson6.TreeImpl;

public class Main {
    public static void main(String[] args) {
        int balanced = 0;
        int noBalanced = 0;
        int height = 4;

        for (int i = 0; i < 20; i++) {
            if (createTree(height)) {
                balanced++;
            } else {
                noBalanced++;
            }
        }

        System.out.printf("Сбаланисрованных - %d, Несбаланисрованных - %d",balanced,noBalanced);
    }

    private static boolean createTree(int height) {

        int max = 20;
        int min = -20;

        Tree<Integer> tree = new TreeImpl<>();

        do {

            int node = (int) (Math.random() * ((max - min) + 1)) + min;
            tree.add(node);

        } while (tree.height() < height);

        tree.display();

        return tree.isBalanced();
    }
}
