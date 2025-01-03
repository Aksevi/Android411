package Lesson13.Shapes;
// 25 9 min

public abstract class Shape {
    private String color;
// конструктор
    public Shape(String color) {
        this.color = color;
    }
// геттеры и сеттеры
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
// абстрактные методы которые обязательно будут реализованы в дочерних классах
   // площадь
    public  abstract double getArea();
    // периметр
    public abstract double getPerimeter();
    // метод вывода информации
    public abstract void  info();
    // печать фигуры
    public abstract void draw();
}
