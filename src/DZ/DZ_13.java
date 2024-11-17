package DZ;

import java.util.Scanner;

public class DZ_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // без рекурсии и метода
/*        int[] mas = {1, 2, -3 , 5, -7};
        int negativeCount = 0; // счетчик отрицательных чисел. сейчас равен 0
        for (int num: mas){ // перебираем числа в массиве. num - просто любое число в массиве
            if (num < 0){ // если число  меньше нуля то ->
                negativeCount++; // увеличиваем счетчик отрицательных чисел на 1
            }
        }
        System.out.println("отрицательных чисел: " + negativeCount); // выводим результат*/

        // с методом

/*        int [] mas = {1, 2, -3 , -5, -7};
        System.out.println("Отрицательных чисел: " + sumNegative(mas));

    }
    public static int  sumNegative(int [] arr) {
        int negativeCount = 0;
        for(int num: arr)
            if(num < 0){
                negativeCount ++;
            }
            return negativeCount;
        }*/

        // с рекурсией
        System.out.println("Домашнее задание");

        int [] mas = {1, -2, 3, -5, -7};
        System.out.println(sumNegative(0, mas));
    }

    public static int  sumNegative(int i, int [] arr){
        if (i == arr.length)
            return 0;
//        int negative = arr[i] < 0 ? 1 : 0; // то же самое что и 44-46 строки
        int negative = 0;
        if (arr[i] < 0){
            negative++;
        }

        return negative + sumNegative(i + 1, arr);


    }

}
