package DZ;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DZ_16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

// проверяем палиндром фраза или нет

        // мое

/*        System.out.print("Введи фразу: ");
        String text = scanner.nextLine(); // вводим фразу
//        String text = "а роза упала на лапу азора"; // начальное слово
//        System.out.println(text);
        String result = ""; // результат. изначально он пустой


        String line = text.replace(" ", ""); // создаем временную переменную с которой будем работать убираем пробелы чтобы корректно сравнивать изначальное и перевернутое слово
        line = line.toLowerCase(); // переводим в нижний регистр чтобы сравнивал корректно
        for (int i = 0; i < line.length(); i++) { // идем циклом по слову

            result = line.charAt(i) + result; // присваиваем результату буквы пока они не кончаться в слове (в цикле). например в слове строка -  итерация 0 (i = 0) line.charAt(0) = 'С' result = 'С';  итерация 1 (i = 1) line.charAt(1) = 'т' result = 'тС'; итерация 2 (i = 2) line.charAt(2) = 'р' result = 'ртС' и так далее - > так получается потому что формула такая "result = line.charAt(i) + result;" поменяй местами ("result = result + line.charAt(i);") и строка не перевернется


        }
        System.out.println(text + " -> " + line.equalsIgnoreCase(result)); // выводим результат. если палиндром то true/ если нет то false*/


        // на уроке 18 начало

/*        System.out.println(isPalindrome("Лидер Венере не вредил"));
        System.out.println(isPalindrome("Могу добавить"));
    }
        public static boolean isPalindrome(String str) {
            String result = "";
            str = str.toLowerCase().replace(" ", ""); // все в нижний регистр и убираем пробелы

            for (int i = 0; i < str.length(); i++) {
                result = str.charAt(i) + result; // разворачиваем строку
            }
            System.out.println(result);
        return str.equals(result) ? true : false;*/


        }

}
