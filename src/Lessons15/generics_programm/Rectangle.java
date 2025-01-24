package Lessons15.generics_programm;
// 28 1-53
public class Rectangle extends Figure {

    private double width, heigth;

// констр
    public Rectangle(double width, double heigth) {
        this.width = width;
        this.heigth = heigth;
    }

// метод нах площади
    @Override
    public double getArea() {
        return width * heigth;
    }
}
