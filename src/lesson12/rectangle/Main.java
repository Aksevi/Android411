package lesson12.rectangle;

public class Main {
    public static void main(String[] args) {
        First first = new First(10, 10, "yellow");
        first.showInfo();
        Second second = new Second(10, 10, "1x232");
        second.showInfo();

    }
}
// родит класс
class Rectangle {
    private int width;
    private int length;
// конструктор
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }
    // метод вывода данных класса Rectangle
    public void showInfo(){
        System.out.printf("\nПрямоугольник\nШирина: %s\nДлина: %s", width, length);
    }

}
// 1 дочерний класс
class First extends Rectangle{
    private String background;
// конструктор
    public First(int width, int length, String background) {
        super(width, length);
        this.background = background;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("\n1 дочерний метод - Цвет: %s\n", background);
    }
}
// 2 дочерний класс
class Second extends Rectangle {
    private String ground;
// конструктор
    public Second(int width, int length, String ground) {
        super(width, length);
        this.ground = ground;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("\n2 дочерний метод - Рамка: %s", ground);
    }
}
