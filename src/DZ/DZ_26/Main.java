package DZ.DZ_26;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //    Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Rectangle rectangle = new Rectangle(100, 150);

        System.out.print("Изначально: \n");
        rectangle.display();

        // Изменяем размеры

        System.out.print("Ведите width -> ");
        int newWidth = scanner.nextInt();
        System.out.print("Ведите heigth -> ");
        int newHeigth = scanner.nextInt();
        rectangle.resizeWidth(newWidth);
        rectangle.resizeHeigth(newHeigth);

        System.out.print("После изменений: \n");
        rectangle.display();
    }

}
