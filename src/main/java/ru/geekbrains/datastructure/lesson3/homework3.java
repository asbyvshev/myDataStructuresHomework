package ru.geekbrains.datastructure.lesson3;

import ru.geekbrains.datastructure.lesson3.stack.Stack;
import ru.geekbrains.datastructure.lesson3.stack.StackImpl;

public class homework3 {
    public static void main(String[] args) {
        String string = "asdf";
        System.out.println(string);
        System.out.println(RightToLeft(string));
    }

    public static StringBuilder RightToLeft(String str){
        String string = str;
        Stack<Character> characterStack = new StackImpl<>(string.length());
        for (int i = 0; i < string.length(); i++){
            characterStack.push(string.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) sb.append(characterStack.pop());
        return sb;
    }

}
