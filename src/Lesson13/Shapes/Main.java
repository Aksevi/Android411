package Lesson13.Shapes;

public class Main {
    public static void main(String[] args) {
/*        // созд экз класса square
    Square square = new Square(3, "red");
        //вызываем метод инфо  info  экз класса square
    square.info();

    Rectangle rectangle = new Rectangle(7, 3, "green");
        rectangle.info();

        Triangle triangle = new Triangle(5, "yellow");
        triangle.info();*/

// вывод инфы методом полиморфизма
      Shape[] shapes = new Shape[3];
      shapes[0] = new Square(3, "red");
      shapes[1] = new Rectangle(7, 3, "green");
      shapes[2] = new Triangle(5, "red");

// здесь shape - имя временной переменной придуманное нами, shapes - название массива  из стр 16 - 19
      for(Shape shape: shapes){ // проходимся в цикле по массиву с фигурами
          shape.info();

      }
    }
}
