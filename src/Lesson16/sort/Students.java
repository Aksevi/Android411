package Lesson16.sort;

//31 2-36
public class Students {
    public static void main(String[] args) {

            Person p1 = new Person("Саша", 25);
            Person p2 = new Person("Евгений", 24);
            int res = p1.compareTo(p2);// сравниваем p1 и p2
        System.out.println(res);
        switch (res) {
            case -1:
                System.out.println(p2.getName() + " старше");
                break;
            case 1:
                System.out.println(p1.getName() + " старше");
            default:
                System.out.println("Эти люди одного возраста");
        }
    }
}
//  интерфейс сравнения. в нем обязательно переопределить метод см стр40
class Person implements Comparable<Person> {
    private String name;
    private int age;

    // конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // геттер для имени
    public String getName() {
        return name;
    }


    //переопределенный метод сравнения по определенным параметрам
    @Override
    public int compareTo(Person o) {
        if (this.age == o.age) // o это переменная из строки выше
            return 0;
        else
            return this.age > o.age ? 1 : -1;
    }
}