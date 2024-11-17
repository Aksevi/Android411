package DZ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class HW_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вычисление площади фигур");
        int n;
        System.out.print("Выбери фигуру: \n 1 - круг \n 2 - прямоугольник \n 3 - треугольник \n --> ");
        n = input.nextInt();
        if (n == 1){ // площадь круга для расчёта площади круга через радиус используется формула S = π × r2
            System.out.print("Введите радиус: ");
        float r = scanner.nextFloat();
        System.out.printf("Площадь круга: %.2f", Math.PI * Math.pow(r, 2));//%.2f округляет до 2 символов после точки.

        } else if(n == 2){ // площадь прямоугольника = длина * ширину
            System.out.print("Введите длину: ");
        float h = scanner.nextFloat();
        System.out.print("Введите ширину: ");
        float w = scanner.nextFloat();
        float s = h * w;
        System.out.printf(" Площадь прямоугольника: %.2f", s); //%.2f округляет до 2 символов после точки.

        } else { // площадь треугольника вычисляется по формуле Герона кв корень из p*(p - a) * (p - b) * (p - c) где p - полупериметр
            System.out.print("Введите 1 сторону: ");
        float a = scanner.nextFloat();
        System.out.print("Введите 2 сторону: ");
        float b = scanner.nextFloat();
        System.out.print("Введите 3 сторону: ");
        float c = scanner.nextFloat();
        float p = (a + b + c) / 2; // p - полупериметр
        System.out.printf("Площадь треугольника: %.2f", Math.sqrt (p*(p - a) * (p - b) * (p - c))); // %.2f округляет до 2 символов после точки.
        }


        // площадь круга для расчёта площади круга через радиус используется формула S = π × r2,
//        System.out.print("Введите радиус: ");
//        float r = scanner.nextFloat();
//
//        System.out.printf("Площадь круга: %.2f", Math.PI * Math.pow(r, 2)); // %.2f округляет до 2 символов после точки.

//        // площадь прямоугольника
//        System.out.print("Введите длину: ");
//        float h = scanner.nextFloat();
//        System.out.print("Введите ширину: ");
//        float w = scanner.nextFloat();
//        float s = h * w;
//
//        System.out.printf(" Площадь прямоугольника: %.2f", s); // %.2f

//        // площадь треугольника вычисляется по формуле Герона кв
//        System.out.print("Введите длину основания: ");
//        float a = scanner.nextFloat();
//        System.out.print("Введите высоту: ");
//        float h = scanner.nextFloat();
//        float s = (a * h) / 2;
//        System.out.printf("Площадь треугольника: %.2f", s);






    }
}
