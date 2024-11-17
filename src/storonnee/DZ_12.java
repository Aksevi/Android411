package storonnee;

import java.util.Scanner;

public class DZ_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        char a, b, c;
        System.out.print("Введите n: ");
        n = input.nextInt();
        System.out.print("Введите символ 1: ");
        a = input.next().charAt(0); // выбираем символ
        System.out.print("Введите символ 1: ");
        b = input.next().charAt(0); // выбираем символ

        symbol(n, a, b);
    }
    public static void symbol(int n, char a, char b){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n * 2; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n * 2 - 1)
                    System.out.print("=");

                else if (i == 0 || i == n - 1 || j % 2 != 0 || j == n * 2 - 1)
                    System.out.print((char) a);
                else
                    System.out.print((char) b);
            }
            System.out.println();
        }
    }
}