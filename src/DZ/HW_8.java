package DZ;

import java.util.Scanner;
import java.util.Arrays;

public class HW_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // разбираем на уроке 9 в начале самом

        int n = 0, k = 0, size; //  n начало, k - конец диапазона size - количество элементов
        int[] diap; // массив
        System.out.print("Введи начало диапазона: ");
        n = input.nextInt();
        System.out.print("Введи конец диапазона: ");
        k = input.nextInt();
        if (n < k) { // если значение начала диапазона меньше чем значение конца то производим вычисления
            size = (k - n) + 1; // вычисляем размер диапазона. +1 чтобы диапазон включал крайние точки. например диапазон от 5 до 10 -> (10 - 5) = 5, 5 + 1 = 6 - длина диапазона (5, 6, 7, 8, 9, 10)
            System.out.println("Размер диапазона: " + size); // выводим размер диапазона
            diap = new int[size]; // присваиваем массиву размер диапазона
            for (int i = 0; i < diap.length; i++) { // заносим значения диапазона в массив. i - просто счетчик
                diap[i] = n + i; // значения массива начало диапазона (n) + значение i на каждой итерации до тех пор пока i не достигне предла диапазона
                System.out.print(diap[i] + " ");

            }

        } else { // если значение начала диапазона больше чем значение конца то выдаст ошибку

            System.out.println("Ошибка! Начало диапазона не может быть меньше чем окончание.");

        }


// этот вариант тоже рабочий но то что сверху мне интереснее плюс там только то что изучали без заимствований из сети

/*        if (n > k) { // если начало меньше конца - выдаст ошибку
            System.out.println("Ошибка. Конец диапазона не может быть меньше, чем начало");
            return; // break не работал пришлось в сети смотреть чем заменить :(
        }
        size = (k - n) + 1; // вычисляем размер диапазона. +1 чтобы диапазон включал крайние точки. например диапазон от 5 до 10 -> (10 - 5) = 5, 5 + 1 = 6 - длина диапазона (5, 6, 7, 8, 9, 10)
        System.out.println("Размер диапазона: " + size); // выводим размер диапазона
        diap = new int[size]; // присваиваем массиву размер диапазона
        for (int i = 0; i < diap.length; i++) { // заносим значения диапазона в массив. i - просто счетчик
            diap[i] = n + i; // значения массива начало диапазона (n) + значение i на каждой итерации до тех пор пока i не достигне предла диапазона
            System.out.print(diap[i] + " ");
        }*/



    }

}
