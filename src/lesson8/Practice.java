package lesson8;

import Lesson7.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Practice {
    public static void main(String[] args) {

        // ур 17 2-43 продолжение на ур 18 17 мин

        try { // код try - catch ловит ошибку
//            String s = "Час в 24-м формате о 00 до 23. 2021-06-15Т21:45. Минуты в диапазоне от 00 до 59. 2021-06-15Т01:09.";
            String s = "Цифры: 7, +17, -42, 0013, 0.3"; // урок 18 1-10
//            String pattern = "[0-2][0-9]:[0-5][0-9]";
//            String pattern = "\\d"; // задача найти все цифры 7, +17, -42, 0013, 0.3 урок 18 1-10
//            String pattern = "\\d+"; // задача найти все цифры 7, +17, -42, 0013, 0.3
             String pattern = "[+-]?[\\d.]+"; // задача найти все цифры 7, +17, -42, 0013, 0.3

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(s);

            while (matcher.find()) {
                System.out.println(matcher.group());

            }
        } catch (PatternSyntaxException pse) { // PatternSyntaxException - сама ошибка. pse -  ее имя данное мной
            System.out.println("Неправильное регулярное выражение: " + pse.getMessage()); // вывод ошибки и где она
            System.out.println("Описание: " + pse.getDescription()); // вывод ошибки и описание
            System.out.println("Позиция: " + pse.getIndex()); // вывод ошибки и ее позицию
            System.out.println("Неправильный шаблон: " + pse.getPattern()); // вывод ошибки и кусок кода, где ошибка

        }

    }
}
