package Lesson16.Collection;

import java.util.LinkedHashSet;

public class LinkedHashSet12 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> name = new LinkedHashSet<>();
        name.add(7);
        name.add(4);
        name.add(2);
        name.add(3);
        name.add(8);
        System.out.println(name);//[7, 4, 2, 3, 8] сохр порядок ввода
// .get не работает. индекса нету, элементы уникальные - повторяться не будут

        name.remove(4); // удалят по значению
        System.out.println(name);// [7, 2, 3, 8]
        System.out.println(name.contains(4));//false  проверка наличия
        System.out.println(name.contains(3));//true

        System.out.println(name.removeIf(x -> x > 5));// удаляем значения больше 5 (по заданному условию)
        System.out.println(name);//[2, 3]
    }
}
