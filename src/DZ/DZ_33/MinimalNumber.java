package DZ.DZ_33;

import java.util.*;

public class MinimalNumber {
    public static void main(String[] args) {
        System.out.println("Создайте программу, которая наполнит TreeSet 5-ю целыми числами с клавиатуры и выведет наименьший и наибольший элемент");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
// создаем список TreeSet
        TreeSet<Integer> num = new TreeSet<>();

        System.out.println("Введите 5 целых чисел: ");

// вводим пока не введем 5 чисел
        for (int i = 0; i < 5; i++) {
//ловим ввод нецелого числа (20-26 стр)
            try {
                System.out.print("-> ");
                num.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести целое число!");
                scanner.nextLine();
            }
        }
        System.out.println("Наименьший элемент: " + num.first());
        System.out.println("Наибольший элемент: " + num.last());
    scanner.close();
    }

}
