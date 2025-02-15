package Lesson16.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 35 0-18
public class HashMap2 {
    public static void main(String[] args) {
// экз класса принимает значения типа Student, Double
        Map<Student, Double> map = new HashMap<>();

        Student st1 = new Student("Виктор", "Борисов", 2);
        Student st2 = new Student("Анна", "Полякова", 3);
        Student st3 = new Student("Ирина", "Ренатова", 1);
// добавляем в map по экз класса и по среднему баллу st - ключ со всем его значением  которе см в строке st1, st2, st3 соответственно
        map.put(st1, 8.6);
        map.put(st2, 7.9);
        map.put(st3, 9.3);
        System.out.println(map);
        Student st4 = new Student("Виктор", "Борисов", 2);// добавим такого же студента
        boolean res = map.containsKey(st4);
        System.out.println("res = " + res);
// смотрим HashCode
        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st4.hashCode());

        for (Map.Entry<Student, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());// до двоеточия - ключ. после - значение
        }

        System.out.println(map.containsKey(st1));
        System.out.println(map.hashCode());


    }
}

class Student {
    // final private для того чт обы нельзя менять ключ
   final private String name;
    final private String surname;
    final private int course;

    // конструктор
    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student { " +
                " name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", course = " + course +
                '}';
    }

    // 35 0-30 сравнение для корректной работы стр 21-23
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

//    сами переделали чисто для примера
//        @Override
//    public int hashCode() {
//        return name.length() + surname.length() + course;
//    }
}