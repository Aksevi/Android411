package Lessons15.Generics;

import java.util.ArrayList;
import java.util.Arrays;

// 28 45 мин
public class Sample5 {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("Исходный список: " + numbers);
        System.out.print("Перевернутый список: ");
        System.out.println(reverseList(numbers));

        ArrayList<String> colours = new ArrayList<>(Arrays.asList("red", "green", "orange"));
        System.out.println("Исходный список: " + colours);
        System.out.print("Перевернутый список: ");
        System.out.println(reverseList(colours));


    }
// 28 1 час
    public static <T> ArrayList <T> reverseList(ArrayList<T> originalList){
        ArrayList<T> newArray = new ArrayList<>(); // создаем новый объект
// разворачиваем массив
        for (int i = originalList.size() - 1; i >= 0 ; i--) { // i = originalList.size() - 1 последний элемент
            newArray.add(originalList.get(i));

        }
        return newArray;
    }
}
