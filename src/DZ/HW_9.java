package DZ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class HW_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
// возводим каждый элемент матрицы в квадрат

        int[][] num = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 14, 16}
        };
        for (int i = 0; i < num.length; i++) {
            System.out.println(Arrays.toString(num[i])); // выводим содержимое массива
        }
        System.out.println();
        for (int i = 0; i < num.length; i++) { // перебор списков
            for (int j = 0; j < num[i].length; j++) { // перебор элементов в списке
            int q = num[i][j] * num[i][j]; //  возведение их в квадрат
                System.out.print(q + "\t"); // вывод
                // 23 и 24 строки можно заментить одной 26й
//                System.out.print(num[i][j] * num[i][j] + "\t"); // вывод элементов и возведение их в квадрат
            }
                        System.out.println();

        }



    }
}
