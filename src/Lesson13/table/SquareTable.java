package Lesson13.table;

public class SquareTable extends Table {

    // конструктор для прямоуг стола
    public SquareTable(int width, int height) {
        super(width, height);
    }
// конструктор для квадратного стола где только width
    public SquareTable(int width) {
        super(width);
    }

    // Переопределяем абстрактный метод calcArea в родительском классе. Потому, что переопределять (выводить инфу только для этого класса) будем его
    @Override
    public void calcArea() {
        //%n в комбинации printf дает перенос на новую строку
        System.out.printf("Ширина: %d%nВысота: %d%nПлощадь: %d%n%n", getWidth(), getHeight(), getWidth()*getHeight());

    }
}
