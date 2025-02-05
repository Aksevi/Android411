package Lesson16.Collection;

import java.util.ArrayDeque;

public class ArrayDeque14 {
    public static void main(String[] args) {
        ArrayDeque<String> name = new ArrayDeque<>();
        name.add("red");
        name.add("blue");
        name.add("white");
        name.add("green");
        name.add("black");

        System.out.println(name);//[red, blue, white, green, black]
// просто get не работает индексов нет
        System.out.println(name.getFirst());//red   getFirst работает
        System.out.println(name.getLast());//black  getLast работает
        System.out.println(name);// [red, blue, white, green, black]

        while (name.peek() != null){
            System.out.println(name.pop());// удаляет пока не закончатся
        }
        System.out.println(name);// []
    }
}
