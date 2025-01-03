package Lesson13.Shapes;

public class Triangle extends Shape {

    private double side;


    public Triangle( int side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3)*side*side)/4;
    }

    @Override
    public double getPerimeter() {
        return side * 3;
    }

    @Override
    public void info() {
        System.out.printf("=== Равносторонний треугольник ===\n" + "Сторона: %.0f\nЦвет : %s\nПлощадь: %.1f\nПериметр: %.1f",side, getColor(), getArea(), getPerimeter());

        draw();
    }
// метод рисования треугольника
    @Override
    public void draw() {
        // ограничиваем цикл одной стороной треугольника.
        for (int i = 0; i <= side; i++) { // проходимся циклом по длине стороны
            for (int j = i; j < side; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" *  ");
            }
            System.out.println();


            
        }

    }
}
