package Lesson13.Shapes;

public class Square extends Shape {

    private int side;
// конструктор/ вручную менЯем side b color в скобках. изначально color первый
    public Square(int side, String color) {
        super(color);
        this.side = side;
    }

    // ctrl + o выбор переопределяемых методов. выбираем абстрактные методы из Shape
    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public double getArea() {
        return side * side;
    }
// цвет  берем из родительского класса Shape остальное из Square
    @Override
    public void info() {
        System.out.println("=== Квадрат ===\nСторона: " + side + "\nЦвет : " + getColor() + "\nПлощадь: " + getArea() + "\nПериметр: " + getPerimeter());
// сразу же вызываем метод draw для рисования фигуры в Main
        draw();

    }
// рисуем фигуру
    @Override
    public void draw() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
        System.out.println();

    }
}
