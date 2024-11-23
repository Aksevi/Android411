package DZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DZ_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст: ");
       // String s = "Hello, World";
        String s = scanner.nextLine();

        System.out.println(s);
        int upp = 0;
        int down = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

//            if (ch >= 'a' && ch <= 'z') // считывает только английские буквы
            if (ch >= 'a' && ch <= 'z' || ch >= 'а' && ch <= 'я') // считывает и английские и русские
                down++;
//            else if (ch >= 'A' && ch <= 'Z') // считывает только английские буквы
            else if (ch >= 'A' && ch <= 'Z' || ch >= 'А' && ch <= 'Я') // считывает и английские и русские
                upp++;

        }
        System.out.println("Количество строчных букв" + " - " + down + ", " + "количество прописных букв" + " - " + upp);










    }

}
