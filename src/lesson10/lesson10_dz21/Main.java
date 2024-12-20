package lesson10.lesson10_dz21;

public class Main {
    public static void main(String[] args) {

        System.out.println("Площадь треугольника по формуле Герона (3, 4, 5): " + Area.triangleArea1(3, 4, 5));
        System.out.println("Площадь треугольника через основание и высоту (6,7): " + Area.triangleArea2(6, 7));
        System.out.println("Площадь квадрата (7) : " + Area.sqrtArea(7));
        System.out.println("Площадь прямоугольника (2, 6): " + Area.rectangleArea(2, 6));
        System.out.println("Количество подсчетов площади: " + Area.getCount());

    }


}
