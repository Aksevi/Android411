package lesson10.numbers;

// ур 21 2-40

public class Main {
    public static void main(String[] args) {

        System.out.println("Максимальное число: " + Numbers.max(3, 5, 7, 9));
        System.out.println("Минимальное число: " + Numbers.min(3, 5, 7, 9));
        System.out.println("Среднее арифметическое: " + Numbers.average(3, 5, 7, 9));
        System.out.println("Факториал: " + Numbers.factorial(5));
    }
}
