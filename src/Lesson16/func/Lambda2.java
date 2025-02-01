package Lesson16.func;
// 31 18
import java.util.Scanner;
import java.util.function.Predicate;

public class Lambda2 {
    public static void main(String[] args) {
        Predicate<Integer> isPrime = number -> {
            if (number <= 1)
                return false;
//            for (int i = 2; i < Math.sqrt(number); i++) { // идем от 2 до корня числа и проверяем делится ли число без остатка (% - остаток от деления)
            for (int i = 2; i < number; i++) { // то же самое что 10 стр
                if (number % i == 0)// % - остаток от деления
                    return false;
            }
            return true;
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("введите число: ");
        int num = scanner.nextInt();
//        int num1 = 4;
//        int num2 = 12;
//        System.out.println(num1 + " простое число: " + isPrime.test(num1));
//        System.out.println(num2 + " простое число: " + isPrime.test(num2));
        System.out.println(num + " простое число: " + isPrime.test(num));
    }
}
