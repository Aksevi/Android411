package Lessons15.Generics;
// 27 2-15+-
public class Sample {
    public static void main(String[] args) {
        Point <Integer, String> pt = new Point<Integer, String>(1, 2, "point_1");// <Integer> (и др ) ограничивает тип данных который примет 27 2-15
//        pt.x = 10;
//        pt.y = 20;

        System.out.println(pt.getX() + " " + pt.getY());

        Point<Double, Integer> pt2 = new Point<>(10.5, 20.6, 1); // можно указывать double в new Point можно просто <>
//        pt2.x = 15.7;
//        pt2.y = 10.5;
        System.out.println(pt2.getX() + " " + pt2.getY());
    }
}

class Point <Tt, V> {
    private V id;
    private Tt x, y;

// конструктор

    public Point(Tt x, Tt y, V id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
// геттеры
    public Tt getX() {
        return x;
    }

    public Tt getY() {
        return y;
    }

    public V getId() {
        return id;
    }
}



