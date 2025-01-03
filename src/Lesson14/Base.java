package Lesson14;

public class Base {
    public static void main(String[] args) {

//        Shape[] geom = new Shape[3];
//        geom[0] = new Line(5, "red", 1, 2, 3, 4);
//        geom[1] = new Rectangle(2, "yellow", 5, 10);
//
//       geom[2] = new Triangle(3, "green", 4, 10);
//// обращаемся к массиву Shape создаем переменную g и по очереди в цикле в нее кладем элементы массива
//       for (Shape g: geom){
//// обращаемся к методу draw/ выводится: Рисуем линии, Рисуем прямоугольник, Рисуем треугольник
//           g.draw();
//           if (g instanceof MathShape){ // если элемент массива имеет обращение к interface MathShape то
//              double s = ((MathShape)g).getSquare(); // создаем временную переменную s в которую записываем площадь. ((MathShape)g) - приводим g типу данных MathShape. ((MathShape)g).getSquare() - вызываем метод вычисления площади из дочерних классов
//               System.out.println("Площадь: " + s);
//
//           }
//       }
//
////        System.out.println(geom[2] instanceof  MathShape);
//

        Line l = new Line(5, "red", 1, 2, 3, 4);
        System.out.println(l);
        l.setCoord(150, 160, 170, 180);
        System.out.println(l);
        System.out.println(GeomInterface.MIN_COORD);
        System.out.println(GeomInterface.MAX_COORD);
        GeomInterface.showInterval();

    }
}
