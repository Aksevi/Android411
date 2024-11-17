package storonnee;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Выберите фигуру для вычисления площади:");
        System.out.println("1 - круг \n2 - Прямоугольник \n3 - Треугольник \n->");

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

        } else if (n == 3)


            System.out.print("основание = ");
            float base = input.nextFloat();
            System.out.print("высота = ");
            float height = input.nextInt();
            double area = res(base, height);
        System.out.printf("Результат %.2f", res(base, height));

        }
        public static double res ( double r){

            return Math.PI * r * r;
        }
        public static double res (double h, double w){

            return h * w;
    }
        public static double res (float base, float height){

            return 0.5 * base * height;





        }

    }
