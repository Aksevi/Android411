package Lesson16.sort;
// 32  6

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {
    // осн класс main
    public static void main(String[] args) {
// экз класса
        University un1 = new University("Университет", 300);
        University un2 = new University("Начальная школа", 150);
        University un3 = new University("Средняя школа", 357);
        University un4 = new University("Высшая школа", 246);
        University un5 = new University("Музыкальная школа", 789);
// экз дополнит  класса
        SortUniversity sortUniv = new SortUniversity();
// перемнаая в которой результат вызова метода
        int res = sortUniv.compare(un1, un2);

        switch (res) {
            case 1:
                System.out.println(un1.getName() + " Больше по численности!");
                break;
            case -1:
                System.out.println(un2.getName() + " Больше по численности!");
                break;
            default:
                System.out.println(" Одинаковы по численности");
        }

// 32 29 мин делаем разные сортировки

        ArrayList<University> list = new ArrayList<>();// созд массив
        list.add(un1);// добавляем экз класса в массив
        list.add(un2);
        list.add(un3);
        list.add(un4);
        list.add(un5);
        System.out.println("\nСортировка по имени:");
//экз класса  SortNameUniversity   с именем  nameCompare
        SortNameUniversity nameCompare = new SortNameUniversity();
// 32 37 !  Collections - общий класс для всех коллекций. служебный!!!!
        Collections.sort(list, nameCompare);

        for (University name : list) {
            System.out.println(name.getName() + " " + name.getNum_of_students());// по алфавиту сорировка будет

        }
// 32 48
        System.out.println("\nСортировка по количеству учеников:");
        Collections.sort(list, sortUniv);

        for (University count : list) {
            System.out.println(count.getName() + " " + count.getNum_of_students());// по колву учеников сорировка будет
        }

    }
}

// класс University
class University {

    private String name;
    private int num_of_students;

    // конструктор
    public University(String name, int num_of_students) {
        this.name = name;
        this.num_of_students = num_of_students;
    }

    // геттеры
    public String getName() {
        return name;
    }

    public int getNum_of_students() {
        return num_of_students;
    }
}

// вспомогательный класс/ Comparator - служебный готовый класс/
class SortUniversity implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) { // o1 o2 == un1 un2

        if (o1.getNum_of_students() == o2.getNum_of_students())
            return 0;
        else
            return o1.getNum_of_students() > o2.getNum_of_students() ? 1 : -1;
    }
}

// еще вспомогательный класс/ Comparator - служебный готовый класс/
class SortNameUniversity implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getName().compareTo(o2.getName()); // .compareTo сравнение строк
    }
}