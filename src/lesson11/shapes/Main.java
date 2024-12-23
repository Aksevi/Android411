package lesson11.shapes;

public class Main {
    public static void main(String[] args) {

// экземпляр класса Rectangle с именем rect
        Rectangle rect = new Rectangle(10,20, "green");
// переназначаем weidth
        rect.setWidth(20);
        // переназначаем heigth
        rect.setHeight(-5);
        System.out.println("Ширина: " + rect.getWidth());
        System.out.println("Высота: " + rect.getHeight());
        System.out.println("Цвет: " + rect.getColor());
        System.out.println("Площадь: " + rect.area());

    }
}
