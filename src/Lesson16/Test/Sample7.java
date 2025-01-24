package Lesson16.Test;


import java.util.ArrayList;
import java.util.Arrays;

// 30 2-02
// фильтруем список людей по определенному параметру
interface Bias{
// булевый метод с именем test принимающий объект типа Person с именем p
    boolean test(Person p);
}

// параметры человека
enum PetPreference { // каких животных любит
    DOG, CAT, SNAKE;
}

public class Sample7 {
    public static void main(String[] args) {

// создаем экземпляры класса Person
        Person p1 = new Person("Роман", 35, true, PetPreference.CAT, new ArrayList<>(Arrays.asList("изучение языков", "чтение")));// передаем параметры из класса Person - name, age, указываем экстраверт или нет - true/false,предпочитаемое животное (через PetPreference потому что выбор указан в enum PetPreference), хобби - /new ArrayList<>/ - потому что массив был создан. /Arrays.asList()/ - заполняем массива сразу же
        Person p2 = new Person("Анна", 15, true, PetPreference.SNAKE, new ArrayList<>(Arrays.asList("туризм", "Путешествия")));
        Person p3 = new Person("Саша", 26, false, PetPreference.SNAKE, new ArrayList<>(Arrays.asList("туризм", "бег")));
        Person p4 = new Person("Михаил", 55, true, PetPreference.DOG, new ArrayList<>(Arrays.asList("туризм", "плавание")));
        Person p5 = new Person("Елена", 35, false, PetPreference.CAT, new ArrayList<>(Arrays.asList("рисование", "игры")));

//помещаем в один список. people - просто имя
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));//  создаем новый массив через экземпляры класса Person
        System.out.println(people);

// вызываем метод filter
        System.out.println(filter(people, p -> p.isExtrovert()));// people - массив где хранится общий список с людьми, p -> p.isExtrovert() - по какому параметру делаем сортировку (по методу isExtrovert - это геттер который просто возвращает значение из параметра экстраверт) сортировка по экстраверту
        System.out.println(filter(people, p -> p.getPetPreference() == PetPreference.DOG ? true : false)); // сортировка по собаке. для этого нужно создать геттер(75 стр)

}
    // выводим только тех кто экстраверт. то есть фильтруем по определенному параметру
// статический метод принимающий массив ArrayList типа данных Person с именем people. второй параметр - интерфейс типа данных Bias с именем bias
    public static ArrayList<Person> filter(ArrayList<Person> people, Bias bias) { // filter - имя.
// реализация фильтрации
        // создаем новый массив типа данных Person в котором будет храниться список уже отфильтрованных людей
        ArrayList<Person> filteredPeople = new ArrayList<>();
        for (Person p : people)  // создаем переменную p типа данных People и проходим по массиву people из стр 29
            // добавляем в новый массив добавлять людей только если будет возвращаться значение true по передаваемым параметрам из метода main
            if (bias.test(p))  // bias это переменная (стр 34) типа данных интерфейса Bias (стр 8)/ у нее вызываем метод test и передаем ему значение p
                filteredPeople.add(p); // если true то добавляем в массив filteredPeople людей через метод add.
        return filteredPeople; // возвращаем уже массив отфильтрованных людей
        }

    }

    // реализуем класс Person
    class Person {
        // задаем набор каких либо свойств
        private String name; // имя человека
        private int age; // возраст человека
        private boolean extrovert; // является ли он экстравертом true/false
        private PetPreference petPreference; // какое животное предпочитает/ PetPreference это тип данных, а petPreference - имя переменной
        private ArrayList<String> hobbies; // хобби человека. создаем в виде массива

        // конструктор
        public Person(String name, int age, boolean extrovert, PetPreference petPreference, ArrayList<String> hobbies) {
            this.name = name;
            this.age = age;
            this.extrovert = extrovert;
            this.petPreference = petPreference;
            this.hobbies = hobbies;
        }

        // геттер только для экстраверта
        public boolean isExtrovert() { // такого вида потому что там было булевое значение см стр 28
            return extrovert; // этот геттер возвращает значение поля extrovert из стр 23-27
        }
        // геттер для предпочитаемого живтоногл
        public PetPreference getPetPreference() {
            return petPreference;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", extrovert=" + extrovert +
                    ", petPreference=" + petPreference +
                    ", hobbies=" + hobbies +
                    '}';
        }
    }





