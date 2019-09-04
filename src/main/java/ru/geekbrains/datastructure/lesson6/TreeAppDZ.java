package ru.geekbrains.datastructure.lesson6;

import ru.geekbrains.datastructure.lesson1.Person;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class TreeAppDZ {

    public static void main(String[] args) {
        Random rand = new Random();
        int treeCount = 20;
        int maxLevel = 4;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);

        int maxValue = 25;

        int balancedTreeCount = 0;

        boolean treeView = false;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> theTree = new TreeImpl<>(maxLevel);
            initTree(rand, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedTreeCount++;
                if (!treeView) {
                    treeView = true;
                    theTree.display();
                }
            }
        }

        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (treeCount * 1.0)) * 100) + "%");


        TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getName));
        treeSet.add(new Person(33, "Alex33"));
        treeSet.add(new Person(12, "Alex22"));
        treeSet.add(new Person(25, "Alex55"));

        for (Person person : treeSet) {
            System.out.println(person);
        }


    }

    private static void initTree(Random rand, int nodeCount, int maxValue, Tree theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.add(rand.nextInt(maxValue * 2 + 1) - maxValue);
        }
    }
}