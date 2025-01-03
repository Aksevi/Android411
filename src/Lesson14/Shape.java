package Lesson14;

// 25 1-53
interface GeomInterface{
    int MIN_COORD = 0; // public static final int MIN_COORD = 0
    int MAX_COORD = 1000; // public static final int MIN_COORD = 1000

   static void showInterval(){
        System.out.println("[" + MIN_COORD + "; " + MAX_COORD + "]");
    }
}
// 25 2-26
class InterfaceGroup{
   private  interface  Interface_1 {
       void method_1();

       private void privateMethod(){
           System.out.println("privateMethod");
       }
    }

    interface Interface_2 extends Interface_1 {
        void method_2();

    }
}

class ReleaseInterface implements InterfaceGroup.Interface_2 {
    @Override
    public void method_1() {

    }

    @Override
    public void method_2() {

    }
}

// создаем интерфейс 25 2-26. создается по принципу класса но вместо class указывается interface
interface  MathShape{ // MathShape это придуманное название
// в нем  указываем только название метода без его  реализации.
    double getSquare();

default double getPerimeter(){
    return 0;
    }

}
// 25 2-38
abstract class Geom implements MathShape, GeomInterface{
    int width, color;
// абстрактный метод
    abstract void draw();
}

class Line1 extends Geom{
    @Override
    void draw() {
        System.out.println("Рисование линии");
    }

    @Override
    public double getSquare() {
        getPerimeter();
        return 0;
    }
}


abstract class Shape {
    private int width;
    private String color;
// конструктор
    public Shape(int width, String color) {
        this.width = width;
        this.color = color;
    }

// асбтрактный метод рисования фигуры
    abstract void draw();
}

// 1 дочерний класс
class Line extends Shape implements GeomInterface{

    private int x1, x2, y1,y2;

// конструктор 1 дочернего класса
    public Line(int width, String color, int x1, int x2, int y1, int y2) {
        super(width, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
// метод проверки
    private boolean isCheck(int value){
        return MIN_COORD <= value && value <= MAX_COORD;
    }
// сеттер изменяем его 25 1-58
    public void setCoord(int x1, int y1, int x2, int y2) {

        if (isCheck(x1) && isCheck(y1) && isCheck(x2) && isCheck(y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    @Override
    public String toString() {
        GeomInterface.showInterval();
        return "Координаты линии: " + "x1=" +x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + "\n";
    }

    // переопределяем метод draw
    @Override
    void draw() {
        System.out.println("Рисуем линии");

    }
}
//2 дочерний класс
class Rectangle extends Shape implements MathShape{ // impliments - отправляе к intraface в начале кода

    private int width;
    private int height;

// конструктор 2 дочернего класса
    public Rectangle(int width, String color, int width1, int height) {
        super(width, color);
        this.width = width1;
        this.height = height;
    }
// переопределяем метод draw
    @Override
    void draw() {
        System.out.println("Рисуем прямоугольник");

    }
 // реализуем  метод вычисления площади
    @Override
    public double getSquare(){
        return width * height;
    }
}

class Triangle extends Shape implements MathShape {

    private int length;
    private int height;

    public Triangle(int width, String color, int length, int height) {
        super(width, color);
        this.length = length;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Рисуем треугольник");
    }

    // реализуем  метод вычисления площади
    @Override
    public double getSquare() {
        return 0.5 * length * height;
    }
}