package Lesson13.Shapes;

public class Rectangle extends Shape {

    private int width;
    private int heigth;


// конструктор
    public Rectangle(int width, int heigth,String color) {
        super(color);
        this.width = width;
        this.heigth = heigth;
    }
// переопределяем методы
    @Override
    public double getArea() {
        return width * heigth;
    }

    @Override
    public double getPerimeter() {
        return (width + heigth) * 2;
    }

    @Override
    public void info() {
        System.out.println("=== Прямоугольник ===\nШирина: " + width + "\nВысота" + heigth + "\nЦвет : " + getColor() + "\nПлощадь: " + getArea() + "\nПериметр: " + getPerimeter());

        draw();

    }

    @Override
    public void draw() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
