package Lesson16.Collection;

import java.util.Iterator;
import java.util.TreeSet;

// 33 2-46
public class TreeSet11 {
    public static void main(String[] args) {
        TreeSet<Student2> treeSet = new TreeSet<>();

        Student2 st1 = new Student2("Виктор", 5);
        Student2 st2 = new Student2("Герман", 3);
        Student2 st3 = new Student2("Ольга", 1);
        Student2 st4 = new Student2("Ольга", 4);
        Student2 st5 = new Student2("Михаил", 2);
// добавляем в treeSet
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        System.out.println(treeSet);

// 34 0-19

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());

        Student2 st6 = new Student2("Алена", 3);// студент создан но в treeSet не добавлен!!
        System.out.println(treeSet);
        System.out.println(treeSet.headSet(st6)); // .headSet получает то что идет до 3 курса
        System.out.println(treeSet.tailSet(st6)); // .tailSet получает то что больше или равно 3 курсу
        System.out.println(treeSet.tailSet(st6)); // .tailSet получает то что больше или равно 3 курсу

        Student2 st7 = new Student2("Игорь", 2);// студент создан но в treeSet не добавлен!!
        Student2 st8 = new Student2("Владимир", 4);// студент создан но в treeSet не добавлен!!
        System.out.println(treeSet.subSet(st7, st8));// .subSet выдает диапазон от 2 до 4 не включая 4

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++"); // разделитель
// вывод по порядку
        Iterator<Student2> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++"); // разделитель
// вывод в обратном порядке
        Iterator<Student2> iterator2 = treeSet.descendingIterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}

// класс
class Student2 implements Comparable<Student2> {
    String name;
    int course;

    // конструктор
    public Student2(String name, int course) {
        this.name = name;
        this.course = course;
    }

    // переопред метод ту стринг
    @Override
    public String toString() {
        return "Student2 { " +
                "name = '" + name + '\'' +
                ", course = " + course +
                '}';
    }

    @Override
    public int compareTo(Student2 o) {
        return course - o.course;

    }
}
