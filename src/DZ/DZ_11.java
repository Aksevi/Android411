package DZ;

import java.util.Scanner;

public class DZ_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

// Первый вариант
        System.out.println("Выберите фигуру для вычисления площади:");
        System.out.print("1 - круг \n2 - Прямоугольник \n3 - Треугольник \n-> ");

        int n = input.nextInt();

        if (n == 1) {
            System.out.print("r = ");
            double r = input.nextFloat();
            double area = res(r);
            System.out.printf("Результат %.2f", res(r)); // 1 метод сработал

        } else if (n == 2) {
            System.out.print("h = ");
            double h = input.nextFloat();
            System.out.print("w = ");
            double w = input.nextInt();
            double area = res(h, w);
            System.out.printf("Результат %.2f", res(h, w)); // 2 метод сработал

        } else if (n == 3){


            System.out.print("основание = ");
        float base = input.nextFloat();
        System.out.print("высота = ");
        float height = input.nextInt();
        double area = res(base, height);
        System.out.printf("Результат %.2f", res(base, height)); // 3 метод сработал
    }else
            System.out.println("Попробуй еще раз");



    } // 1 метод
    public static double res (double r){ // вычисляет площадь круга ->

        return Math.PI * r * r; // по радиусу
    } // 2 метод
    public static double res (double h, double w){ // вычисляет площадь прямоугольника ->

        return h * w; // по высоте и ширине
    } // 3 метод
    public static double res (float base, float height){ // вычисляет площадь треугольника ->
                return 0.5 * base * height; // по высоте и основанию

// второй вариант
/*        System.out.println("Фигура: \n1 - Прямоугольник\n2 - Круг\n3 - Треугольник");
        int figure = input.nextInt();
        if(figure == 1){
            rectangle();
        } else if (figure == 2){
            krug();
        } else if (figure == 3){
            triangle();
        }
        else{
            System.out.println("ошибка");
        }


    } public static void rectangle(){ // 1
        Scanner input = new Scanner(System.in);
        System.out.print("ширина: ");
        float w = input.nextInt();
        System.out.println("высота: ");
        float h= input.nextInt();
        System.out.printf("площадь: %.2f ",  w * h);
    }

    public static void krug(){ // 2
        Scanner input = new Scanner(System.in);
        System.out.print("радиус: ");
        float r = input.nextInt();
        System.out.printf("площадь: %.2f ",  Math.PI * r * r);

    }

    public static void triangle(){ // 2
        Scanner input = new Scanner(System.in);
        System.out.print("Основание: ");
        float base = input.nextFloat();
        System.out.print("Высота: ");
        float height = input.nextFloat();
        System.out.printf("площадь: %.2f ", 0.5 * base * height);*/





    }


}
































