package DZ;

import java.util.Scanner;

public class DZ_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       // 1 вариант без метода

/*        int n;
        System.out.print("Введите n: ");

       n = input.nextInt();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n * 2 - 1)
                    System.out.print("=");

                else if (i == 0 || i == n - 1 || j % 2 != 0 || j == n * 2 - 1)
                    System.out.print("/");
                else
                    System.out.print("\\");

            }
            System.out.println();
        }*/

        // второй вариант с методом

        int n;
        System.out.print("Введите n: ");
        n = input.nextInt();

        symbol(n);
    }
    public static void symbol(int n){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n * 2 - 1)
                    System.out.print("=");

                else if (i == 0 || i == n - 1 || j % 2 != 0 || j == n * 2 - 1)
                    System.out.print("/");
                else
                    System.out.print("\\");
            }
            System.out.println();
        }

        // 3 вариант с методом и выбором символа

/*        int n;
        char a, b, c;
        System.out.print("Введите n: ");
        n = input.nextInt();
        System.out.print("Введите символ 1: ");
        a = input.next().charAt(0); // выбираем символ
        System.out.print("Введите символ 2: ");
        b = input.next().charAt(0); // выбираем символ
         System.out.print("Введите символ 3: ");
        c = input.next().charAt(0); // выбираем символ

        symbol(n, a, b, c);
    }
    public static void symbol(int n, char a, char b, char c){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n * 2 - 1)
                    System.out.print((char) a);

                else if (i == 0 || i == n - 1 || j % 2 != 0 || j == n * 2 - 1)
                    System.out.print((char) b);
                else
                    System.out.print((char) c);
            }
            System.out.println();
        }*/


// урок 13 2 мин разбор дз 12 доделать!!!!

//        Scanner input = new Scanner(System.in);
//
//        System.out.print("n = ");
//        int ch = input.nextInt();
//        printHeaderFooter(ch);
//        for (int i = 0; i < ch; i++) {
//            printMiddleRow(ch);
//        }
//        printHeaderFooter(ch);
//
//    }
//    public static void printMiddleRow(int n){
//        for (int i = 0; i < n - 1; i++) {
//            System.out.print("=");
//        }
//        System.out.print("=");
//    }
//
//    public static void printHeaderFooter(int n){
//        for (int i = 0; i < n * 2; i++) {
//            System.out.print("=");
//        }
//        System.out.println();



    }

}
