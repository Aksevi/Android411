package lesson6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
// урок 15 27 мин
/*        try { // попытаться
            System.out.print("введите первое число: ");
            int a = input.nextInt();
            System.out.print("введите второе число: ");
            int b = input.nextInt();

            System.out.println((double) a / b); // через double приводим к нецелым числам (например 5 -> 5.0 и тд)
        } catch (InputMismatchException e) { // поймать (е это просто имя исключения. может быть любым)
            System.out.println("Вы ввели нецелое число: " + e);
        } catch (ArithmeticException e){ // тоже можно имя е так как обе е за пределами видимости друг друга. можно любое имя
            System.out.println("Делить на ноль нельзя " + e); // сработает только если убрать double из стр 16

        }*/

// вариант второй -  два исключения за один раз указываются урок 15 45 мин
/*        try { // попытаться
            System.out.print("введите первое число: ");
            int a = input.nextInt();
            System.out.print("введите второе число: ");
            int b = input.nextInt();

            System.out.println(a / b);
        } catch (InputMismatchException | ArithmeticException e) { // поймать (е это просто имя исключения. может быть любым)
            System.out.println("Вы ввели нецелое число: " + e);
            System.out.println("Делить на ноль нельзя " + e);

        } finally {
            System.out.println("Конец программы");
        }*/

        // ур 15 55 мин выход за пределы диапазона массива
/*    try {
    int[] numbers = new int[3];
    numbers[3]=9;
} catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Введен некорректный индекс - " + e);

        }*/

     // факториал числа и исключения   ур 15 1-02  (5! (6!) = 1*2*3*4*5 (*6) и тд)

        System.out.print("введи число ");
        int n = input.nextInt();
        int res = getFactorial(n); // getFactorial наш созданный метод поиска факториала. название любое
        System.out.println(res); // вывод результата работы метода
    }

    public static int getFactorial(int num) { // num это число которое мы ввели
        int mul = 1; // переменная в которую факториал записывается
        try { // ловим ошибку
            if (num < 1){
                throw new Exception("Число меньше 1 указать нельзя");
            }
            for (int i = 1; i <= num; i++) { // перебираем все натуральные числа до введенного нами включительно
                mul *= i; // перемножаем числа
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            mul = num; // 66 - 68 стр вывод ошибки если ввели число меньше 1
        }

        return mul; // возвращаем результат поиска факториала в стр 54

    }

}
