package Lesson13.table;
//25 1-19
public abstract class Table {
// св-ва для одного класса
    private int width;
    private int height;
// св-ва для другого класса
    private double radius;

// конструктор для прямоугольного стола
    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }
// создаем конструктор для квадр стола с одно только стороной и приравниваем ее к другой
    public Table(int width) {
        this.width = this.height = width;
    }

    // конструктор для круглого стола
    public Table(double radius) {
        this.radius = radius;
    }
// геттеры для всех свойств
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public abstract void calcArea();

}
