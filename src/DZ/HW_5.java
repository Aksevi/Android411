package DZ;

import java.util.Scanner;

public class HW_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int h; // час
        System.out.println("введите количество часов: ");
        h = input.nextInt();
        switch ((h >= 0 && h < 6) ? 1 : (h >= 6 && h < 13) ? 2 : (h >= 13 && h < 17) ? 3 : (h >= 17 && h <= 23) ? 4 : 0) {
/*            case 1 -> System.out.print("Доброй ночи");
            case 2 -> System.out.print("Доброе утро");
            case 3 -> System.out.print("Добрый день");
            case 4 -> System.out.print("Добрый вечер");
            case 0 -> System.out.print(" Ошибка");*/
            case 1:
                System.out.print ("Доброй ночи");
                break;
            case 2:
                System.out.print ("Доброе утро");
                break;
            case 3:
                System.out.print ("Добрый день");
                break;
            case 4:
                System.out.print ("Добрый вечер");
                break;
            case 0:
                System.out.print (" Ошибка");
                break;


        }
    }

}
