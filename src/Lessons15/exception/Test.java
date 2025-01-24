package Lessons15.exception;

import java.util.Scanner;

// 28 11 min
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("первое число: ");
        String first = input.nextLine();

        System.out.print("второе число: ");
        String second = input.nextLine();

        int a = 0;
        int b = 0;

        try { // обработка исключений чтобы вводились только числа
            a = Integer.parseInt(first); // преобазование к целочисловому значению
            b = Integer.parseInt(second); // преобазование к целочисловому значению
        } catch (NumberFormatException e) { // e - любое имя
            System.out.println("Одно или оба значения некорректны");

        }
        System.out.print("Результат: " + (a + b));
    }
}

