package lesson6;

import javax.accessibility.AccessibleTable;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // лифт
/*        System.out.print("На каком вы этаже: ");
        int n1 = input.nextInt();
        elevator(n1);
    }
    public static void elevator(int n){
        if (n == 0){
            System.out.println("Вы в подвале");
            return;
        }
        System.out.println("=> " + n);
        elevator(n - 1); // стек: здесь сохраняются все значение которые сюда попали и в 21 строке выведутся по принципу наоборот. первой попала 5 потом 4 потом 3 и тд. выведутся наоборот - 5 последней и тд
        System.out.print(n + " ");*/

// урок 13 16 мин сумма элементов в массиве

        // первый вариант без рекурсии

/*        int[] mas = {1, 2, 3 , 5, 7};
        System.out.println(sumList(mas));
    }
    public static int sumList(int[] arr){// arr  = (это наше имя массива) {1, 2, 3 , 5, 7}
        int sum = 0;
        for (int i: arr){ // по очереди каждый элемент массив берет и в сумму добавляет
            sum += i; // sum = sum + i -> 0 + 1 потом 1 + 3 (след элемент) и тд
    }
        return sum; // возвращается в System.out.println(sumList(mas));
  }*/


        // 2 вариант 32 мин с рекурсией
/*            int[] mas = {1, 3, 5, 7, 9};
        System.out.println(sumList(0, mas));
    }
    public static int sumList(int i, int [] arr) {//  sumList - имя метода, i = 0 (индекс массива),  arr (это наше имя массива) = {1, 2, 3 , 5, 7}
        if (i == (arr.length - 1)) // i == 4, до тех пор пока i не станет равно длине массива - 1 47 стр не сработает и переходим в стр 51
            return arr[i];
//        if (i == arr.length)
//            return 0;

        return arr[i] + sumList(i + 1, arr);//  1 + 3 + 5 + 7 + 9 если вместо + будет * то элементы перемножатся
    }*/


        // конвертирование числа в различные системы 13 урок 1:05

/*        System.out.println(toStr(254, 16)); // n - число, base - система исчисления
    }

    public static String toStr(int n, int base) {
        String[] convert = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        if (n < base)
            return convert[n];// попадем сюда только если выполнится условие 58 стр
        else
            return toStr(n / base, base) + convert[n % base]; //  если десятеричная система (254 / 10 = 25, 10) + convert [ остаток от деления 254 на 10 = 4] -> 4 (число под индексом 4 в массиве convert) и тд (см урок)
    }*/


// урок 13 1-45 см {lesson 6 -> Menu}

        // разбор дз 13 урок 15 начало

    int[] arr = {-2, 3, 8, -11, -4, 6};
        System.out.println("n = " + calcNegativeNumbers (arr, 0)); // index слово без вызова метода тупо не появится. Внимательнее!!!
    }
    public static int calcNegativeNumbers(int[] numbers, int index){
        if(index == numbers.length)
            return 0;
        return (numbers[index] < 0 ? 1 : 0) + calcNegativeNumbers(numbers, index + 1);

    }
}
