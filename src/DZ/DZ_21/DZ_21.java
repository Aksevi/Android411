package DZ.DZ_21;

import java.util.Scanner;

public class DZ_21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        System.out.println("Выбери фигуру:");
        System.out.println("Треугольник 1");
        System.out.println("Квадрат 2");
        System.out.println("Прямоугольник 3");

        int n = input.nextInt(); // выбор фигуры

        if (n == 1) {

            System.out.print("Введи первую сторону -> ");
            float a = input.nextInt();
            System.out.print("Введи вторую сторону -> ");
            float b = input.nextInt();
            System.out.print("Введи третью сторону -> ");
            float c = input.nextInt();
            float p = (a + b + c) / 2;
            double area1 = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.printf("Площадь треугольника равна (%.0f, %.0f, %.0f): %.1f", a, b, c, area1);
            count++;
            System.out.println("\nВсего: " + count);

        } else if (n == 2) {
            System.out.print("Введи сторону квадрата -> ");
            float a = input.nextInt();
            double area2 = a * a;
            System.out.printf("Площадь квадрата (%.0f, %.0f): %.1f", a, area2);

        } else if (n == 3) {
            System.out.print("Введи длину прямоугольника -> ");
            double a = input.nextInt();
            System.out.print("Введи длину прямоугольника -> ");
            double b = input.nextInt();
            double area3 = a * b;
//            System.out.printf("Площадь прямоугольника (a): %.1f", area);
            System.out.printf("Площадь прямоугольника (%.0f, %.0f): %.1f", a, b, area3);

        } else {
            System.out.println("Неправильный выбор");
return;

        }

    }
}