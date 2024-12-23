package storonnee.Animals;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        // экземпляр родительского класс
        Animals animals = new Animals("кто-то",5);
        animals.speak();
        // экземпляр 1 дочернего класса
        Dog dog = new Dog("Тузик", 3, "дворняга");
        dog.speak();
        System.out.println("Порода: " + dog.breed);
        // экземпляр 2 дочернего класса
        Cat cat = new Cat("Мотя", 6, "рыжий");
        cat.speak();
        System.out.println("Возраст " + cat.age + "\nЦвет: " + cat.colour);



    }
}
