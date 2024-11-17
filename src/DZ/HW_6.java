package DZ;

import java.util.Scanner;

public class HW_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n, y, i = 0; // n - количество символов, y - переменная горизонталь\вертикаль, i -счетчик
        int symbol; // запрашиваемый символ
        System.out.print("введите количество символов: ");
        n = input.nextInt(); // вводим количество символов
        System.out.print("0 по горизонтали, 1 по вертикали: ");
        y = input.nextInt(); // выбыираем горизонталь(0) или вертикаль (1)
        System.out.print("Выберите символ для вывода: ");
        symbol = input.next().charAt(0); // выбираем символ
        while (i < n) {
//            if(y == 0) {
//                System.out.print(" " + (char)symbol + " ");
//                i++;
//            } else{
//                System.out.println(" " + (char)symbol + " ");
//                i++;
//            }
//        }
            for (i = 0; i < n; i++) {
                if(y == 0){ // если в ориентации выбрали 0 то
                    System.out.print(" " + (char) symbol + " "); // работает это (выводим не с новой строки print)
                } else { // если 1
                    System.out.println(" " + (char) symbol + " ");// то это (выводим с новой строки println)
                }
            }
        }




    }
}