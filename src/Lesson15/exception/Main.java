package Lesson15.exception;
// 29 1-44
public class Main {
    public static void main(String[] args) throws NegativeWidthException {

// созд экземпляр класса квадрата
        Square square = new Square(-2);

        System.out.println("Ширина квадрата " + square.getWidth());
        System.out.println("Площадь " + square.calculateArea(square.getWidth()));

    }
}
// наш класс исключений
class NegativeWidthException extends Exception{

// констр с String значением(сообщение)
    public NegativeWidthException(String message) {
        super(message);
    }
}
// класс квадрат
class Square{
    private int width;
// констр
    public Square(int width) {
        this.width = width;
    }
// геттер и сеттер
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
// метод площади
    public  int calculateArea(int width) throws NegativeWidthException{

        if (width > 0){
       return width * width;
        }
        else{
            throw new NegativeWidthException("Ширина квадрата: " + width + " значение не может быть нулевым или отрицательным");
        }
    }
}