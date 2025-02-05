package Lesson16.Collection;

import java.util.Comparator;
import java.util.PriorityQueue;

//34 2-25
public class PriorityQueue14 {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(String :: length));// 34 2-30 Comparator.comparingInt(String :: length) сортировка по числовым выражениям - String :: length удаляет по количеству букв
        priorityQueue.add("Александр");
        priorityQueue.add("Игорь");
        priorityQueue.add("Андрей");

        System.out.println(priorityQueue);//[Александр, Игорь, Андрей]
        while (!priorityQueue.isEmpty()){// пока не пустой
            System.out.println(priorityQueue.remove());// удаляем -> Игорь Андрей Александр


        }
    }
}
