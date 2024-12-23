package lesson12.Shape;
// 24 1 час
public class Main {
    public static void main(String[] args) {
        // созд массив из 3 фигур. имя Shape потому как остальные наследуются от Shape
        Shape s[] = new Shape[3];
        s[0] = new Circle();
        s[1] = new Triangle();
        s[2] = new Square();

        for (int i = 0; i < s.length; i++) { // проходимся по длине массива
            System.out.println(s[i].draw()); // обращ к элементу массива с индексом i и вызываем метод
            System.out.println(s[i].erase());// обращ к элементу массива с индексом i и вызываем метод
        }
    }
}

class Shape{

    public String draw(){
        return "Рисуем фигуру";
    }
    public String erase(){
        return "Стираем фигуру";
    }
}
// дочерний от Shape
class Circle extends Shape{
    // alt+ins
    @Override
    public String draw() {
//        return super.draw(); // по умолчанию будет это. заменим на стр ниже
        return "Рисуем круг";
    }
    // alt+ins
    @Override
    public String erase() {
//        return super.erase(); // по умолчанию будет это. заменим на стр ниже
        return "Стираем круг";
    }
}
// дочерний от Shape
class Triangle extends Shape{
    // alt+ins
    @Override
    public String draw() {
//        return super.draw(); // по умолчанию будет это. заменим на стр ниже
        return "Рисуем треугольник";
    }
    // alt+ins
    @Override
    public String erase() {
//        return super.erase(); // по умолчанию будет это. заменим на стр ниже
        return "Стираем треугольник";
    }
}
// дочерний от Shape
class Square extends Shape{
    // alt+ins
    @Override
    public String draw() {
//        return super.draw(); // по умолчанию будет это. заменим на стр ниже
        return "Рисуем квадрат";
    }
    // alt+ins
    @Override
    public String erase() {
//        return super.erase(); // по умолчанию будет это. заменим на стр ниже
        return "Стираем квадрат";
    }
}