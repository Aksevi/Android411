package lesson10;
// урок 22 1-13
public class Sample2 {
    public static void main(String[] args) {
        Dog d1 = new Dog("Шарик");
        d1.run();
    }
}

class Dog{
    private String name;
    // создаем экземпляр вложенного класса
    private Foot foot;

// конструктор
    public Dog(String name) {
        this.name = name;
        foot = new Foot();
    }

    void run(){
        foot.run(); // вызывает метод run из класса Foot
    }

    class Foot{
       void run(){
           String name = "Foot";
            System.out.println("Собака " + name + " бежит..."); // обращается к name из void run. если убрать String name = "Foot"; то будет обращаться к name из class Dog
            System.out.println("Собака " + Dog.this.name + " бежит...");// обращается к name из class Dog
        }
    }
}
