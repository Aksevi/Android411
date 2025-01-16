package DZ.DZ_25;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

// если нужен ввод от пользователя то  с 9 до 20 строки
        Scanner scanner = new Scanner(System.in);
        System.out.print("Радиус: ");
        double radius = scanner.nextDouble();
        System.out.print("Высота: ");
        double heigth = scanner.nextDouble();
        System.out.print("Основание: ");
        double baseArea = scanner.nextDouble();
// полиморфизм. создаем массив из 3 элементов
        Figure[] figures = new Figure[3];
        figures[0] = new Sphere(radius);
        figures[1] = new Cylinder(radius, heigth);
        figures[2] = new Pyramide(radius, baseArea);

// если ввод не нужен и используем уже заданные параметры то с 23 до 27 стр
// полиморфизм. создаем массив из 3 элементов
/*        Figure[] figures = new Figure[3];
        figures[0] = new Sphere(4.2);
        figures[1] = new Cylinder(4.2, 5);
        figures[2] = new Pyramide(4.2, 5);*/

// без полиморфизма
/*        Sphere sphere = new Sphere(4.2);
        sphere.info();

        Cylinder cylinder = new Cylinder(4.2, 5);
        cylinder.info();

        Pyramide pyramide = new Pyramide(4.2, 5);
        pyramide.info();*/

// пробегаем по массиву и в переменную f кладем по очереди значения элементов массива. если исползуем версию без полиморфизма то строк 39-42 убираем
        for (Figure f: figures){
// выводим результат
        f.info();
        }
    }
}
