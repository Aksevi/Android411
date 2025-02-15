package Lesson17.Serializable_package;

import java.io.*;
import java.util.ArrayList;

// ДОКУМЕНТ ИЗ СТР 9 СОЗДАЛСЯ ТАМ ГДЕ ДЕРЕВО ФАЙЛОВ . ИМЯ - person
// 36 0-32
public class Main {
    public static void main(String[] args) {

// запись в файл
//   try / catch - делаем обработку исключений чтобы при обращении к файлу которого нет не было ошибки
/*        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) { // ObjectOutputStream - служ метод. oos - просто имя которое дали мы/ FileOutputStream("") - служ метод записи в файл, в кавычках - придуманное имя
            Person p = new Person("Александр", 37, 187, true);// экземпляр класса  Person, p - просто имя/ в скобках - данные из класса Person - имя, возраст, рост, женат ли
            oos.writeObject(p);//oos - наша переменная из стр 9\ .writeObject - запись файла\ (p) - наш экземпляр класса  из  стр 10

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
// чтение из файла
//   try / catch - делаем обработку исключений чтобы при обращении к файлу которого нет не было ошибки
/*        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) { // ObjectInputStream - служ метод. ois - просто имя которое дали мы/ FileInputStream("") - служ метод чтения файла, в кавычках - придуманное имя
            Person p1 = (Person) ois.readObject(); // метод readObject() возвращает тип данных Object поэтому делаем прямое приведение к типу данных Person -> (Person)/ эти данные сохр в переменной p

            System.out.println("Name: " + p1.getName() + "\nAge: " + p1.getAge());// геттеры есть поэтому выводим так - p.getName(), p.getAge() и тд

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

// 36 0-54   ДОКУМЕНТ ИЗ СТР 9 СОЗДАЛСЯ ТАМ ГДЕ ДЕРЕВО ФАЙЛОВ . ИМЯ - people
     String fileName = "people.txt"; // для имени сохраняемого файла можно создать переменную
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Михаил", 30, 175, false));
        people.add(new Person("Александр", 37, 187, true));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(people);
            System.out.println("Файл был записан");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

// чтение из файла
        ArrayList<Person> newPeople = new ArrayList<>();// созд новый arraylist
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) { // ObjectInputStream - служ метод. ois - просто имя которое дали мы/ FileInputStream("") - служ метод чтения файла, в кавычках - придуманное имя
            newPeople = (ArrayList<Person>) ois.readObject();// явное преобразоывание типа в ArrayList<Person> и дальше читаем из файла и присваиваем в newPeople

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Person p : newPeople){// проходимся в цикле по списку  newPeople и кладем по очереди в переменную p
            System.out.println("Файл прочитан:" + "\nName: " + p.getName() + "\nAge: " + p.getAge());// выводим
        }
    }
}

class Person implements Serializable { // implements Serializable обязателен!!!
    private String name;
    private int age;
    private double height;
    private boolean married;

    // конструктор
    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    // геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMarried() {
        return married;

    }
}
