package DZ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Выберите фигуру для вычисления площади:");
        System.out.print("1 - круг \n2 - Прямоугольник \n3 - Треугольник \n-> ");
        int n = input.nextInt();

        if (n == 1) {
            System.out.print("r = ");
            double r = input.nextFloat();
            double area = res(r);
            System.out.printf("Результат %.2f", res(r));

        } else if (n == 2) {
            System.out.print("h = ");
            double h = input.nextFloat();
            System.out.print("w = ");
            double w = input.nextInt();
            double area = res(h, w);
            System.out.printf("Результат %.2f", res(h, w));

        } else if (n == 3){

            System.out.print("основание = ");
            float base = input.nextFloat();
            System.out.print("высота = ");
            float height = input.nextInt();
            double area = res(base, height);
            System.out.printf("Результат %.2f", res(base, height));
        }else
            System.out.println("Попробуй еще раз");

    } // 1
    public static double res (double r){ // вычисляет площадь круга ->

        return Math.PI * r * r; // по радиусу
    } // 2
    public static double res (double h, double w){ // вычисляет площадь прямоугольника ->

        return h * w; // по высоте и ширине
    } // 3
    public static double res (double base, float height){ // вычисляет площадь треугольника ->
        return 0.5 * base * height; // по высоте и основанию


    }

}