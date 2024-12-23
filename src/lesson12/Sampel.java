package lesson12;
// 24 2-21
public class Sampel {
    public static void main(String[] args) {
//         Cat cat = new Cat("Том");
//         cat.makeSound();
//         cat.sleep();
// создаем массив класса Animal
        Animal animals[] = new Animal[2];
        animals[0] = new Dog("Герда");
        animals[1] = new Cat("Том");
        for (Animal a : animals){ // идем по всем элем массива. a просто переменная временная
            a.makeSound();
            a.sleep();
        }
    }
}
// абстрактный класс
 abstract class Animal{
    private String name;

    // конструктор
    public Animal(String name) {
        this.name = name;
    }
 // геттер
    public String getName() {
        return name;
    }

// обычный метод
public void sleep(){
    System.out.println(name + " спит");
}

// абстрактный метод
    public abstract void makeSound(); // конструкция такая без {}
}

// дочерний класс
class Dog extends Animal{
    // конструктор
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гавкает");

    }
}
// дочерний класс
class Cat extends Animal{
    // конструктор
    public Cat(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " мяукает");

    }
}
