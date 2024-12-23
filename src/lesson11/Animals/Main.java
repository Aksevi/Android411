package lesson11.Animals;

public class Main {
    public static void main(String[] args) {
//       Animal animal = new Animal();
//        animal.voice(); // т.к метод в род классе  void до без sout

        Cat animal1 = new Cat();
        animal1.voice(); // т.к метод в род классе void до без sout
        animal1.voice("Мурзик "); // т.к метод в род классе void до без sout

//        Dog animal2 = new Dog();
        Animal animal2 = new Dog();
        animal2.voice();
    }
}
