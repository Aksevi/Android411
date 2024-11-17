package DZ;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите пятизначное число: ");
        int num = input.nextInt();
        int res = num;
        int a, b, c, d, e;
        a = num % 10;
        num = num / 10;
        b = num % 10;
        num = num / 10;
        c = num % 10;
        num = num / 10;
        d = num % 10;
        num = num / 10;
        e = num % 10;
        int res1 = (a * b * c * d * e);
        int res2 = ((a + b + c + d +e) / 5);
        System.out.println("Произведение цифр числа " + res + ": " + res1);
        System.out.printf("Среднее арифметическое числа " + res + ": " + (float) res2);

        input.close();


    }
}
