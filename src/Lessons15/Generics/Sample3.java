package Lessons15.Generics;

public class Sample3 {
    public static void main(String[] args) {
        Point2<Integer> pt = new Point2<>(1, 2);
        Point2<Double> pt2 = new Point2<>(1.0, 2.3);
// equalsPoint метод сравнения pt1 и pt2  стр 21
        System.out.println(pt.equalsPoint(pt2)); // в методе pt2 это pt!!
//        System.out.println(pt.getMax());
//        System.out.println(pt2.getMax());
    }
}
class Point2<T extends Number>{ // Numbers означает только цифровые типы данных. это служебный тип
    public T x, y;

    public Point2(T x, T y) {
        this.x = x;
        this.y = y;
    }
// 28   9 min
    boolean equalsPoint(Point2<?> pt){ // ? означет что работать может с любыми типами данных
        return x.doubleValue() == pt.x.doubleValue() && y.doubleValue() == pt.y.doubleValue(); // x.doubleValue() приводит к double
    }

// метод нахождения макс числа. приводит все знач к типу double (только числовые)
    double getMax(){
        double xd = x.doubleValue(); // первое число
        double yd = y.doubleValue(); // второе число

        return (xd < yd) ? yd : xd;

    }
}