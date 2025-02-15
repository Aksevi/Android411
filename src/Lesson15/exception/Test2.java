package Lesson15.exception;

// 29 24 min исключение деления на ноль
public class Test2 {
    public static void main(String[] args) {
        int numbers[] = {4, 8, 16, 32, 64, 128};
        int denominator[] = {2, 0, 4, 4, 0, 8};
// вывод содержимого массивов и деление сразу их элементов
        for (int i = 0; i < numbers.length; i++) { // длины обоих одинаковы поэтому можно брать длину любого

            try { // в try catch оборачиваем то где ошибка
                System.out.println(numbers[i] + " / " + denominator[i] + " = " + numbers[i] / denominator[i]);
            } catch (ArithmeticException e) {
                System.out.println("На ноль не делят");
            }
        }
    }
}
