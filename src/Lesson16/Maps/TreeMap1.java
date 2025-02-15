package Lesson16.Maps;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
//        TreeMap<String ,String> fileExteption = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        TreeMap<String ,String> fileExteption = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        fileExteption.put("Python", "*.py");
        fileExteption.put("JavaScript", "*.js");
        fileExteption.put("Goland", "*.jo"); 
        fileExteption.put("C++", "*.cpp");
        fileExteption.put("Java", "*.java");
        fileExteption.put("java", "*.java");

        System.out.println(fileExteption);
//        System.out.println(fileExteption.get("Java"));// доступ по значению
//        fileExteption.remove("Goland");// удаление по значению
//        System.out.println(fileExteption);// удаление по значению
//        System.out.println(fileExteption.descendingMap());// выводит развернутый список но не сохраняет. можно пересохранить в новую переменну.
//
//        System.out.println(fileExteption.lastEntry());// посл элемент
//        System.out.println(fileExteption.firstEntry());// первый элемент
    }
}
