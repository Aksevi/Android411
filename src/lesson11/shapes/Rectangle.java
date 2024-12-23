package lesson11.shapes;

public class Rectangle extends Figure{

    private int width;
    private int height;
// конструктор
    public Rectangle(int width, int height, String color) {
        super(color);
//        this.width = width;
//        this.height = height;
// для того чтобы проверки корректно работали не только через сеттеры и геттеры но и через создание экземпляра класса
        setWidth(width);
        setHeight(height);
    }

    // геттеры и сеттеры так как private

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        // 1 вариант проверки на вводимое число
        if (width < 0){
            throw new IllegalArgumentException("Требуется положительное число!"); // прервет выполнение программы и выбросит исключение если условие выполнится
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        // 2 вариант проверки на вводимое число
        if (height > 0)
        this.height = height;
    }

    public int area(){
        return width * height;
    }
}
