package Lesson7;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // строи урок 15 1-37
/*        String str1 = "Hello";
        String str2 = "World";
        str2 = str2 + "!"; // перезаписываем в str2 новое значение - это новая переменная  с новым значением
        String message = str1 + " " + str2;
        System.out.println(message);*/

        // преобразуем тип данных в строке ур 15 1-49

/*        char[] helloArray =  {'П', 'р', 'и', 'в', 'е', 'т'};
        String helloString  = new String(helloArray); // создаем новый объект типа данных стринг и преобразуем массив чар к типу данных стринг
        System.out.println(helloString);*/


/*        String str1 = "hello";
        int a = 5;
        String message = str1 + " " + a; // неявное преобразование типов. если есть оператор + то он сделант объединение строк
        System.out.println(message);*/

/*        String str1 = "2";
        int a = 5;
        String message = str1 + a;
        System.out.println(message); // = 25, потому что строка с числом объединилась
        */

        // преобразование число в строку ур 15 1-57


/*
        int a = 5;
        String message = "" + a;
        System.out.println(message);
*/

        // преобразование строки в число ур 15 1-59
/*
        String str1 = "2";
        int a = 5;
        int message = Integer.parseInt(str1) + a; // преобразование строки в целочисленное значение
        System.out.println(message);*/

        // ур 15 2-04
/*
        String str1 = "hello";
        int count = (str1).length();
//        int count = (str1 + 57).length(); // "hello" + 57 -> "hello57".length
        System.out.println(count);*/

//        System.out.println(" ".length());

        // 15 ур 2-09 сохранение строки в одном регистре (нижнем)

/*        String name = "Nikita";
//        String name2 = name.toLowerCase(); //  пересохраняем значение name в name 2 bпреобразуем в нижний регистр
//        System.out.println(name2);
        System.out.println(name.toLowerCase());// не пересохраняем значение name но преобразуем в нижний регистр
        System.out.println(name);*/

/*        String name = "Nikita";
        String name2 = name.toUpperCase(); // в заглавные
        System.out.println(name2);*/
      // ур 15 2-14
/*
        String s = "Я буду хорошим программистом";
        char res = s.charAt(7); // обращаемся к эллементу строкового массива. будет буква х
        System.out.println(res);*/

        // ур 15 2-16.

        String s = "я буду хорошим программистом";
        System.out.println(s);
        int[] result = new int['я' - 'а' + 1]; // создаем массив из символов на заданную длинну. +1 чтобы не было ошибки и включался последний элемент 33 буквы. я - 33 а  - 1 ->
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'а' && ch <= 'я') { // проверяет по кодам символов юникода сh больше или равно коду символа 'a' и тд
                result[ch - 'а']++;

            }
        }
        System.out.println(Arrays.toString(result));
//        for (int i = 0; i < result.length; i++) {
//            System.out.println((char) (i + 'а') + " = " + result[i]);
//        }

        // ур 15 дз 2-53



    }
}
