package Lesson16.Collection;

import java.util.Stack;

public class Stack5 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("Катя");// добавляем элемент
        System.out.println(stack);// [Катя]

        stack.push("Виктор");// тоже добавляем элемент
        System.out.println(stack);//[Катя, Виктор]
        stack.push("Игорь");
        stack.push("Михаил");
        stack.push("Ирина");
        System.out.println(stack);

        stack.remove(2);// удаляем
        System.out.println(stack);

        System.out.println(stack.pop());// .pop удаляет последний элемент
        System.out.println(stack);


    }
}
