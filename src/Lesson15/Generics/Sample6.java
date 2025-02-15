package Lesson15.Generics;
// 28 1-14
public class Sample6 {
    public static void main(String[] args) {
       Digit d1 = new Digit(10); // int
       Digit d2 = new Digit(10.5); // double
       Digit d3 = new Digit(10.5f); // float

        System.out.println(d1.value + ", " + d2.value + ", " + d3.value);
    }
}

class Digit{

    public double value;

// конструктор 28  1-17 / указали дженерик не в классе а в конструкторе
    public <T extends Number> Digit(T value) {
        this.value = value.doubleValue(); // привели к типу double
    }
}
