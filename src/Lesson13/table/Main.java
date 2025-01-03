package Lesson13.table;

public class Main {
    public static void main(String[] args) {

//  экз класса для прямоуг стола
        SquareTable t1 = new SquareTable(20,10);
        t1.calcArea();

//25 1-55
//  экз класса для квадратного стола. Отдельный класс не делаем, а передадим ему только один параметр из прямоугольного стола
        SquareTable t2 = new SquareTable(20);
        t2.calcArea();

//  экз класса длякруглого стола
        RoundTable t3 = new RoundTable(20);
        t3.calcArea();


    }
}
