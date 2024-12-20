package lesson9.rectangle;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

 // класс rect1
        Rectangle rect1 = new Rectangle(4, 15);
// это если сам вводить хочешь. тогда комментируй строки 26-27
/*        System.out.print("длина -> ");
        int length = input.nextInt();
        rect1.setLength(length);
        System.out.print("ширина -> ");
        int weight = input.nextInt();
        rect1.setWeight(weight);*/
// это предустановленные значения 3 и 9 соответственно. комментируй строки 19-24
        rect1.setLength(3);
        rect1.setWeight(9);
        System.out.println("Длина прямоугольника: "  + rect1.getLength());
        System.out.println("Ширина прямоугольника: "  + rect1.getWeight());

        System.out.println("Площадь: " + rect1.getArea());
        System.out.println("Периметр: " + rect1.getPerimetr());
        // так как printf то не + а запятая. %.2f - округление до 2 знаков
        System.out.printf("Гипотенуза: %.2f", rect1.getHipotenuse());
        System.out.println();
        System.out.println();
        rect1.getFigure();

    }


}
