package DZ.DZ_25;

public class Main {
    public static void main(String[] args) {

//        Sphere sphere = new Sphere(4.2);
//        sphere.info();
//
//        Cylinder cylinder = new Cylinder(4.2, 5);
//        cylinder.info();
//
//        Pyramide pyramide = new Pyramide(4.2, 5);
//        pyramide.info();

// полиморфизм. создаем массив из 3 элементов
        Figure[] figures = new Figure[3];
        figures[0] = new Sphere(4.2);
        figures[1] = new Cylinder(4.2, 5);
        figures[2] = new Pyramide(4.2, 5);
// пробегаем по массиву и в переменную f кладем по очереди значения элементов массива
        for (Figure f: figures){
// выводим результат
        f.info();
        }
    }
}
