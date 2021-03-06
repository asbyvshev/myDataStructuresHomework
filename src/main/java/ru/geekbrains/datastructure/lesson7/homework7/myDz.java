package ru.geekbrains.datastructure.lesson7.homework7;

import java.util.Stack;

public class myDz {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва",
                "Тула",
                "Рязань",
                "Калуга");

        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");

        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

//        Stack<String> path = graph.findShortPath("Москва","Воронеж");
//        Stack<String> path = graph.findShortPath("Тамбов","Воронеж");
        Stack<String> path = graph.findShortPath("Орел","Липецк");
        System.out.println();

        System.out.println("Крадчайщий путь: " + ShowShortPath(path));
    }

    private static String ShowShortPath(Stack<String> path) {

        StringBuilder sb = new StringBuilder();
        boolean isFist = true;

        while (!path.isEmpty()){

            if (!isFist){
                sb.append(" -> ");
            }

            isFist = false;
            sb.append(path.pop());
        }
        return String.valueOf(sb);
    }
}
