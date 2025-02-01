package Lesson16.Collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class List3 {
    public static void main(String[] args) {
// вызываем метод  compareLists
        compareLists();
    }

    public static void compareLists(){
    ArrayList<Double> arrayList = new ArrayList<>();
    LinkedList<Double> linkedList = new LinkedList<>();
// постоянные значения
    final int N = 1000000;
    final int M = 1000;
// цикл ограниченный большим значением
        for (int i = 0; i < N; i++) {
            arrayList.add(Math.random());// добавляем случ числа
            linkedList.add(Math.random());// добавляем случ числа
        }
// замеряем время работы - currentTimeMillis() - в миллисекундах
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
// 33 - 11 считаем разницу между операциями в arraylist и linkedlist
        for (int i = 0; i < M; i++) {
            arrayList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();

        for (int i = 0; i < M; i++) {
            linkedList.get((int) (Math.random() * (N - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);



    }
}
