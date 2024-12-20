package DZ.DZ_21;

public class DZ_21_1 {
    public static void main(String[] args) {
        System.out.println("Площадь треугольника по формуле Герона (3, 4, 5) " + triangleArea(3, 4, 5));
        System.out.println("Площадь квадрата (7) " + squareArea(7));
        System.out.println("Площадь прямоугольника (2, 6) " + rectangleArea(2, 6));
        System.out.println("Количество подсчетов " + calculateCount());
    }

    private static int count = 0; // переменная счетчика

    // треугольник
    public static double triangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2; // полупериметр
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        count++;
        return area;

    }

    // квадрат
    public static double squareArea(double a) {
        double area = a * a;
        count++;
        return area;

    }

    // прямоугольник
    public static double rectangleArea(double a, double b) {
        double area = a * b;
        count++;
        return area;
    }
    public static int calculateCount(){
        return count;
    }

}
