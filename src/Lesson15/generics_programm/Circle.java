package Lesson15.generics_programm;

public class Circle extends Figure {
// это пример с интерфейсом 28 2-41
//public class Circle implements Figure1 {

    private double radius;
// констр
    public Circle(double radius) {
        this.radius = radius;
    }

//метод нах площади
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
