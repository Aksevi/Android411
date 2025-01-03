package DZ.DZ_26;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(100, 150);

        System.out.print("Изначально: \n");
        rectangle.display();

        // Изменяем размеры
        rectangle.resizeWidth(250);
        rectangle.resizeHeigth(300);

        System.out.print("После изменений: \n");
        rectangle.display();
    }
}
