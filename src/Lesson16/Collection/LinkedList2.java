package Lesson16.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//32 2-10
public class LinkedList2 {
    public static void main(String[] args) {

        Student st1 = new Student("Viktor", 2);
        Student st2 = new Student("Anna", 3);
        Student st3 = new Student("Igor", 1);
        Student st4 = new Student("Roman", 3);
        Student st5 = new Student("Irina", 2);
// создаем список LinkedList - служебный класс. name - придуманное имя
        LinkedList<Student> name = new LinkedList();
        name.add(st1);
        name.add(st2);
        name.add(st3);
        name.add(st4);
        name.add(st5);
// 32 2-17
//        System.out.println("LinkedList = " + name);//LinkedList = [Student{name='Viktor', course=2}, Student{name='Anna', course=3}, Student{name='Igor', course=1}, Student{name='Roman', course=3}, Student{name='Irina', course=2}]
//        System.out.println(name.get(2));//обращаемся к элементу 2 списка name -> Student{name='Igor', course=1}
// созд новых студентов
        Student st6 = new Student("Maria", 2);
        Student st7 = new Student("Sergey", 1);
// добавляем их st6 в конец st7 в индекс 1
        name.add(st6);// если индекс не указан то по умолчанию в конец добавит
        name.add(1,st7);
//        System.out.println("LinkedList = " + name);//LinkedList = [Student{name='Viktor', course=2}, Student{name='Sergey', course=1}, Student{name='Anna', course=3}, Student{name='Igor', course=1}, Student{name='Roman', course=3}, Student{name='Irina', course=2}, Student{name='Maria', course=2}]

        Student st8 = new Student("Vlad", 3);
        name.set(1, st8); // в 1 индекс ставим st8 и st6 перезапишется
//        System.out.println("LinkedList = " + name);//LinkedList = [Student{name='Viktor', course=2}, Student{name='Vlad', course=3}, Student{name='Anna', course=3}, Student{name='Igor', course=1}, Student{name='Roman', course=3}, Student{name='Irina', course=2}, Student{name='Maria', course=2}]
        name.remove(3);// удаляем значение из индекса 3
//        System.out.println("LinkedList = " + name);//LinkedList = [Student{name='Viktor', course=2}, Student{name='Vlad', course=3}, Student{name='Anna', course=3}, Student{name='Roman', course=3}, Student{name='Irina', course=2}, Student{name='Maria', course=2}]

        name.removeFirst();// удалит первый элемент
//        System.out.println("LinkedList = " + name);// LinkedList = [Student{name='Vlad', course=3}, Student{name='Anna', course=3}, Student{name='Roman', course=3}, Student{name='Irina', course=2}, Student{name='Maria', course=2}]

        name.removeLast();// удалит последний элемент
//        System.out.println("LinkedList = " + name);// LinkedList = [Student{name='Vlad', course=3}, Student{name='Anna', course=3}, Student{name='Roman', course=3}, Student{name='Irina', course=2}]

        for (Student element : name){ //  созд переменную element проходим по коллекции
            System.out.print(element);// Student{name='Vlad', course=3}Student{name='Anna', course=3}Student{name='Roman', course=3}Student{name='Irina', course=2}
        }

        for (int i = 0; i < name.size(); i++) {
            System.out.print("Элемент по индексу " + i + ": " + name.get(i));//course=3}Элемент по индексу 2: Student{name='Roman', course=3}Элемент по индексу 3: Student{name='Irina', course=2}

        }
// 32 2-43
        Iterator p = name.listIterator(2);
        while (p.hasNext()) {
            System.out.println(p.next());//Student{name='Irina', course=2}

        }
//32 2-46
        Iterator it = name.descendingIterator(); // проходим по коллекции с конца и выводим задом наперед
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("первый элемент: " + name.getFirst());// вывод первого элемента
        System.out.println("последний элемент: " + name.getLast());// вывод второго элемента
        name.clear();// очистка списка
        System.out.println("LinkedList = " + name);// LinkedList = []

        System.out.println("Список пустой? " + name.isEmpty());// проверяем пустой ли список -> Список пустой? true

        ListIterator<Student> listIterator = name.listIterator();
        System.out.println("Итерация в прямом направлении: ");
        while (listIterator.hasNext()) {
        System.out.println("Index = " + listIterator.nextIndex() + ", Element = " + listIterator.next());
        }

        System.out.println("Итерация в обратном направлении");
        while (listIterator.hasPrevious()){
            System.out.println("Index = " + listIterator.previousIndex() + ", Element = " + listIterator.previous());
        }
    }
}


class Student {

    String studName;
    int course;

    // конструктор
    public Student(String name, int course) {
        this.studName = name;
        this.course = course;
    }
//

    @Override
    public String toString() {
        return "Student { " +
                "name =' " + studName + '\'' +
                ", course = " + course + " " +
                '}';
    }


}
