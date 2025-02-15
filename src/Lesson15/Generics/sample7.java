package Lesson15.Generics;
// 28 1-37
public class sample7 {
    public static void main(String[] args) {
        Point2D<Integer> p1 = new Point2D<>(1, 50, 70);
        Point3D<Float> p2 = new Point3D<>(2f, 10f, 20f, 30f);

        System.out.println(p1);
        System.out.println(p2);

    }
}

class PointProp<T>{ // родит класс
    T id;
// конструктор
    public PointProp(T id) {
        this.id = id;
    }
}

class Point2D <T2D>extends PointProp<T2D>{
    T2D x, y;

// конструктор
    public Point2D(T2D id, T2D x, T2D y) { // 2D это просто добавлено для лучшего восприятия. без нее промто Т будет работать
        super(id);
        this.x = x;
        this.y = y;
    }
// переопределение метода ctrl+o
    @Override
    public String toString() {
        return "id " + id + ": " + x + ", " + y;
    }
}

class Point3D<T3D> extends PointProp<T3D>{ // см коммент стр 23

    T3D x, y, z;
    // конструктор
    public Point3D(T3D id, T3D x, T3D y, T3D z) {
        super(id);
        this.x = x;
        this.y = y;
        this.z = z;
    }
// переопределение метода ctrl+o
    @Override
    public String toString() {
    return "id " + id + ": " + x + ", " + y + ", " + z;
    }
}