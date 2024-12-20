package lesson10;

import java.awt.*;


public class Program {
    public static void main(String[] args) {

        // ур 21 2-04

// создали 2 экземпляра класса Point
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
/*        System.out.println(Point.count);

    }
}
// создаем класс Point. Point просто имя
class Point{
    static int count; // статические свойства урок 21 2-14
    int x; // динамические свойства
    int y; // динамические свойства

    // ур 21 2-20
// Инициализатор. инициализируем первонач знач count если не укажем то будет 0. если count статический то и инициализатор - статический
    static {
        count = 10;
    }

     // конструктор alt + ins создает только динамические!!!
     public Point(int x, int y) {
         this.x = x;
         this.y = y;
         this.count++; // можно и без this просто count++
     }
 }*/

// создаем класс Point. Point просто имя
           System.out.println(Point.getCount());

    }
}
        class Point {
            private static int count; // статические свойства урок 21 2-14
            int x; // динамические свойства
            int y; // динамические свойства

            // ур 21 2-20
// Инициализатор. инициализируем первонач знач count если не укажем то будет 0. если count статический то и инициализатор - статический
            static {
                count = 10;
            }

            // конструктор alt + ins создает только динамические!!!
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
                this.count++; // можно и без this просто count++
            }
// геттер
            public static int getCount() {
                return count;

            }

        }


