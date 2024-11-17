package Lesson3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/*        String symbol;
        int n, orient;
        System.out.print("количество символов:  ");
        n = input.nextInt();
        System.out.print("тип символа: ");
        symbol = input.next();
        System.out.print("0 - по горизонтали\n1 - по вертикали: ");
        orient = input.nextInt();

        for (int i = 0; i < n; i++) {
            if (orient == 1) {
                System.out.print(symbol);
            } else {
                System.out.println(symbol + " ");
            }
        }*/

/*        int n;
        System.out.print("введите число: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++){ // i не ноль потому что делить на 0 нельзя
            if(n % i == 0)
            System.out.print(i + " ");
        }*/



/*        for (int i = 10; i < 100; i += 10) { // i += 10 -> i = i + 10
//            if(i / 10 == i % 10){
                System.out.print(i + " ");

//            }*/

/*            int a = 0;
            for (int i = 5; i > 0; i--, a++){
                System.out.print("шаг: " + a + ". Значение: ");
                System.out.println(i);
            }*/

/*        for (int i = 0; i < 3; i++){
            System.out.println("+++");
            for (int j = 0; j < 2; j++){
                System.out.println("-----");

            }
        }*/

        int w, h;
        System.out.print("Введите ширину прямоугольника: ");
        w = input.nextInt();
        System.out.print("Введите высоту прямоугольника: ");
        h = input.nextInt();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == h - 1 || j == 0 || j == w - 1)
                System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }


/*        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < i; j++) {
               System.out.print("*");
            }
            System.out.println();
        }*/

/*        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i <= j) // если сделать >= то в другую сторону развернет
                    System.out.print("* ");
            }
            System.out.println();
        }*/

/*        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i <= j) // если сделать >= то в другую сторону развернет
                    System.out.print("* ");
                            }
            System.out.println();
        }*/






    }
}
