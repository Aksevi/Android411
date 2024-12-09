package lesson8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static java.awt.SystemColor.text;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        // ур 17 1-41 регулярные выражения. папка 8 в файлах в занятиях

/*        String s = "Я ищу совпадения в 2024 году. И я их найду в 2 счёта. 5910. Hel_lo. Ели[-ели].";
//        String text = "[204]"; // [] означают поиск заданных символов в шаблоне
//        String text = "[12][0-9][0-9][0-9]"; // [] означают поиск заданных символов в шаблоне наличие\отсутсвие пробела критично! и зависит от пробела в шаблоне/ в данном примере первая цифра или 1 или 2//       String text = "[А-Яа-яЁё]"; // ё вне диапазона кодировки и ее надо добавить принудительно
//        String text = "[А-яЁё\\[\\]-]"; // то же самое что и предыдущее но только с русским алфавитом. (в англ так надо [A-Za-z])/  дефис ставим в конце чтобы искался. кв скобки экранируем двойным обратным слэшем
//        String text = "[^0-9]"; // ^0-9 - ищем все что угодно кроме указанного (что не цифры)
//        String text = "\\."; // в чистом виде точка - ищет любой символ кроме новой строк. "\\." - ищет только точки
//        String text = "\\d"; // ищет одну любую цифру. аналог записи [0-9]
//        String text = "\\D"; // ищет все кроме цифр аналог [^0-9]
//        String text = "\\s"; // поиск одного пробельного символа
//        String text = "\\S"; // поиск всего кроме пробелов
//        String text = "\\w"; // поиск букв цифр и символа подчеркивания аналог [A-Za-z0-9_] работает только с англ алф
//        String text = "\\W"; // поиск всего кроме [A-Za-z0-9_]
//        String text = "\\AЯ ищу"; // поиск с начала строки

//          String text = "\\w+"; // ищем не по одному символу рез-т -> 2024 2 5910 Hel_lo
//          String text = "\\d+"; //  рез-т -> 2024 2 5910
          String text = "20*"; //  рез-т -> 20 2 2  - ур 18 1-08 * работает только с последним символом.

        Pattern regex = Pattern.compile(text); // преобразует элемент в шаблон
//        System.out.println(regex);
        Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном
//        System.out.println(matcher.find()); // ищет совпедения и выдает false или true
        while (matcher.find()){ // пока совпадение есть идем по всей строке
//            System.out.println("Шаблон совпадения найден с " + matcher.start() + " по " + (matcher.end() - 1));
//            System.out.println(s.substring(matcher.start(),matcher.end()));
            System.out.print(matcher.group() + " "); // group выводит все совпадения

        }*/


        // ур 18 1-46

/*        String s = "author=Пушкин А.С.; title  = Евгений Онегин; price =200; year= 1831";
//        String text = "[204]"; // [] означают поиск заданных символов в шаблоне
//        String text = "[12][0-9][0-9][0-9]"; // [] означают поиск заданных символов в шаблоне наличие\отсутсвие пробела критично! и зависит от пробела в шаблоне/ в данном примере первая цифра или 1 или 2//       String text = "[А-Яа-яЁё]"; // ё вне диапазона кодировки и ее надо добавить принудительно
//        String text = "[А-яЁё\\[\\]-]"; // то же самое что и предыдущее но только с русским алфавитом. (в англ так надо [A-Za-z])/  дефис ставим в конце чтобы искался. кв скобки экранируем двойным обратным слэшем
//        String text = "[^0-9]"; // ^0-9 - ищем все что угодно кроме указанного (что не цифры)
//        String text = "\\."; // в чистом виде точка - ищет любой символ кроме новой строк. "\\." - ищет только точки
//        String text = "\\d"; // ищет одну любую цифру. аналог записи [0-9]
//        String text = "\\D"; // ищет все кроме цифр аналог [^0-9]
//        String text = "\\s"; // поиск одного пробельного символа
//        String text = "\\S"; // поиск всего кроме пробелов
//        String text = "\\w"; // поиск букв цифр и символа подчеркивания аналог [A-Za-z0-9_] работает только с англ алф
//        String text = "\\W"; // поиск всего кроме [A-Za-z0-9_]
//        String text = "\\AЯ ищу"; // поиск с начала строки

//          String text = "\\w+"; // ищем не по одному символу рез-т -> 2024 2 5910 Hel_lo
//          String text = "\\d+"; //  рез-т -> 2024 2 5910
//        String text = "\\w+\\s*=\\s*[А-я0-9 .]+";
        String text = "\\w+\\s*=[^;]+";

        Pattern regex = Pattern.compile(text); // преобразует элемент в шаблон

        Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном

        while (matcher.find()){ // пока совпадение есть идем по всей строке

            System.out.println(matcher.group() + " "); // group выводит все совпадения

        }*/

        // ур 18 2-06

/*                String s = "12 сентября 2024 года 456789123";
//        String text = "[204]"; // [] означают поиск заданных символов в шаблоне
//        String text = "[12][0-9][0-9][0-9]"; // [] означают поиск заданных символов в шаблоне наличие\отсутсвие пробела критично! и зависит от пробела в шаблоне/ в данном примере первая цифра или 1 или 2//       String text = "[А-Яа-яЁё]"; // ё вне диапазона кодировки и ее надо добавить принудительно
//        String text = "[А-яЁё\\[\\]-]"; // то же самое что и предыдущее но только с русским алфавитом. (в англ так надо [A-Za-z])/  дефис ставим в конце чтобы искался. кв скобки экранируем двойным обратным слэшем
//        String text = "[^0-9]"; // ^0-9 - ищем все что угодно кроме указанного (что не цифры)
//        String text = "\\."; // в чистом виде точка - ищет любой символ кроме новой строк. "\\." - ищет только точки
//        String text = "\\d"; // ищет одну любую цифру. аналог записи [0-9]
//        String text = "\\D"; // ищет все кроме цифр аналог [^0-9]
//        String text = "\\s"; // поиск одного пробельного символа
//        String text = "\\S"; // поиск всего кроме пробелов
//        String text = "\\w"; // поиск букв цифр и символа подчеркивания аналог [A-Za-z0-9_] работает только с англ алф
//        String text = "\\W"; // поиск всего кроме [A-Za-z0-9_]
//        String text = "\\AЯ ищу"; // поиск с начала строки

//          String text = "\\w+"; // ищем не по одному символу рез-т -> 2024 2 5910 Hel_lo
//          String text = "\\d+"; //  рез-т -> 2024 2 5910
//        String text = "\\w+\\s*=\\s*[А-я0-9.]+";


//       String text = "\\d{2}"; // ищем строго 2 цифры идущие подряд
//        String text = "\\d{2,4}"; // ищем строго от 2 до 4 цифр идущих подряд
        String text = "\\d{2,}"; // ищем строго от 2 до бесконечности идущих подряд

        Pattern regex = Pattern.compile(text); // преобразует элемент в шаблон

        Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном

        while (matcher.find()){ // пока совпадение есть идем по всей строке

            System.out.println(matcher.group() + " "); // group выводит все совпадения

        }*/


        // ур 18 2-25 вывести тлф в формате +7xxxxxxxxxx

/*        try {
        String s = "+7 499 456-45-78, +74994564578, +34994564578, +7 (499) 456 45 78, 74994564578";

        String text = "\\+?7\\d{10}"; // + может быть может не быть 7 обязательно символов - 10 штук

        Pattern regex = Pattern.compile(text); // преобразует элемент в шаблон

        Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном

        while (matcher.find()){ // пока совпадение есть идем по всей строке

            System.out.println(matcher.group() + " "); // group выводит все совпадения

        }
        } catch (PatternSyntaxException pse) { // PatternSyntaxException - сама ошибка. pse -  ее имя данное мной
            System.out.println("Неправильное регулярное выражение: " + pse.getMessage()); // вывод ошибки и где она
            System.out.println("Описание: " + pse.getDescription()); // вывод ошибки и описание
            System.out.println("Позиция: " + pse.getIndex()); // вывод ошибки и ее позицию
            System.out.println("Неправильный шаблон: " + pse.getPattern()); // вывод ошибки и кусок кода, где ошибка
            }*/


// ур 18 2-31

/*        try {
            String s = "Java_mas-ter123";

//            String text = "^\\w+\\s\\w+";
//            String text = "\\w+\\s\\w+$";
//            String text = "^\\w+\\s\\w+\\s\\w+\\s\\w+$";// ^...$ поиск от начала строки до конца строки
           String text = "^[\\w-]{3,16}$"; // [] обязательны так как относят их содержимое к диапазону указанному в {}

            Pattern regex = Pattern.compile(text); // преобразует элемент в шаблон

            Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном
            System.out.println(matcher.find());

//            while (matcher.find()){ // пока совпадение есть идем по всей строке
//
//                System.out.println(matcher.group() + " "); // group выводит все совпадения
//
//            }
        } catch (PatternSyntaxException pse) { // PatternSyntaxException - сама ошибка. pse -  ее имя данное мной
            System.out.println("Неправильное регулярное выражение: " + pse.getMessage()); // вывод ошибки и где она
            System.out.println("Описание: " + pse.getDescription()); // вывод ошибки и описание
            System.out.println("Позиция: " + pse.getIndex()); // вывод ошибки и ее позицию
            System.out.println("Неправильный шаблон: " + pse.getPattern()); // вывод ошибки и кусок кода, где ошибка
        }*/

        // ур 19 начало  ФЛАГИ

/*        String s = "Я ищу совпадения в 2024 году. И я их найду в 2 счёта. 5910. Hel_lo. Ели[-ели].";
//        String text = "[204]"; // [] означают поиск заданных символов в шаблоне
//        String text = "[12][0-9][0-9][0-9]"; // [] означают поиск заданных символов в шаблоне наличие\отсутсвие пробела критично! и зависит от пробела в шаблоне/ в данном примере первая цифра или 1 или 2//       String text = "[А-Яа-яЁё]"; // ё вне диапазона кодировки и ее надо добавить принудительно
//        String text = "[А-яЁё\\[\\]-]"; // то же самое что и предыдущее но только с русским алфавитом. (в англ так надо [A-Za-z])/  дефис ставим в конце чтобы искался. кв скобки экранируем двойным обратным слэшем
//        String text = "[^0-9]"; // ^0-9 - ищем все что угодно кроме указанного (что не цифры)
//        String text = "\\."; // в чистом виде точка - ищет любой символ кроме новой строк. "\\." - ищет только точки
//        String text = "\\d"; // ищет одну любую цифру. аналог записи [0-9]
//        String text = "\\D"; // ищет все кроме цифр аналог [^0-9]
//        String text = "\\s"; // поиск одного пробельного символа
//        String text = "\\S"; // поиск всего кроме пробелов
//        String text = "\\w"; // поиск букв цифр и символа подчеркивания аналог [A-Za-z0-9_] работает только с англ алф
//        String text = "\\W"; // поиск всего кроме [A-Za-z0-9_]
//        String text = "\\AЯ ищу"; // поиск с начала строки

//          String text = "\\w+"; // ищем не по одному символу рез-т -> 2024 2 5910 Hel_lo
//          String text = "\\d+"; //  рез-т -> 2024 2 5910
//         String text = "20*"; //  рез-т -> 20 2 2  - ур 18 1-08 * работает только с последним символом.
//        String pattern = "\\w+";
        String pattern = "\\d #поиск цифр";

//        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE); // ищем символы
        Pattern regex = Pattern.compile(pattern, Pattern.COMMENTS); //
//        System.out.println(regex);
        Matcher matcher = regex.matcher(s); // взаимодействует с шаблоном
//        System.out.println(matcher.find()); // ищет совпедения и выдает false или true
        while (matcher.find()) { // пока совпадение есть идем по всей строке
//            System.out.println("Шаблон совпадения найден с " + matcher.start() + " по " + (matcher.end() - 1));
//            System.out.println(s.substring(matcher.start(),matcher.end()));
            System.out.print(matcher.group() + " "); // group выводит все совпадения
        }*/

        // ур 19 21 мин

/*//        String s = "Goods - 500$";
        String s = "Java,\njava,\nJAVA";

//        String pattern = "one.\\w+";
//        String pattern = "500$";
        String pattern = "(?im)^java";

//        Pattern regex = Pattern.compile(pattern, Pattern.DOTALL); //  Pattern.DOTALL для того чтобы точка или пробел или перенос воспринимались как символ
//        Pattern regex = Pattern.compile(pattern, Pattern.MULTILINE); // Pattern.MULTILINE для того чтобы была возможность работать с строками с переносом как с многострочным тексом
//        Pattern regex = Pattern.compile(pattern, Pattern.LITERAL); // Pattern.LITERAL для того чтобы проигнорировать спецсимвол в шаблоне вместо \\$ пишем в шаблоне просто $
        Pattern regex = Pattern.compile(pattern); // Pattern.LITERAL для того чтобы

        Matcher matcher = regex.matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }*/

        // ур 19 41 мин

/*        String s = "<body>Пример жадного соответствия регулярных выражений</body>";
        String pattern = "<.*?>"; // ? минимальное совпадение выбирает - <body> </body> без ? выведет всю строку
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }*/

        // ур 19 53 мин

/*        String s = "Егорова Алиса Александровна";
//        String pattern = "А.+а"; // Алиса Александровна
        String pattern = "А.+?а"; // Алиса Алекса
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(s);
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }*/


        // ур 19 58 мин

/*        String s = "Word2016, PS6, AI5";

//       String pattern = "[a-z]+\\d*"; // поиск букв и цифр
//      String pattern = "([a-z]+)(\\d*)"; // круглые скобки для возможности получения данных из какой то круглой скобки
        String pattern = "(.(.(.)))"; //
        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group(0) + " ");
            System.out.println(matcher.group(1) + " ");
            System.out.println(matcher.group(2) + " ");
        }*/


// ур 19 1-06 мин

/*        String s = "abc";

        String pattern = "(.(.(.)))"; //
        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);
        matcher.find();
            System.out.println(matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println(i + ": " + matcher.group(i));
        }*/

        // ур 19 1-17 мин

/*        String s = "Ольга и Виталий отлично учатся";

        String pattern = "Петр[А-я]|Ольга|Виталий"; // | в шаблонах работает как ИЛИ . пробелы критичны

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }*/

        // ур 19 1-39 мин


/*        String s = "int = 4, float= 4.0f, double  = 8.0";

        String pattern = "\\w+\\s*=\\s*\\d[.\\w]*"; // ищет любое количество букв, пробелов и знак =, затем любое количество пробелов, цифра [точка, любой символ] любое количество

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }*/


// ищем только int
/*        String s = "int = 4, float= 4.0f, double  = 8.0";

        String pattern = "int\\s*=\\s*\\d[.\\w]*"; // ищет любое количество букв, пробелов и знак =, затем любое количество пробелов, цифра [точка, любой символ] любое количество

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }*/


// ищем только int и float
/*        String s = "int = 4, float= 4.0f, double  = 8.0";

        String pattern = "int\\s*=\\s*\\d[.\\w]*|float\\s*=\\s*\\d[.\\w]*"; // ищет любое количество букв, пробелов и знак =, затем любое количество пробелов, цифра [точка, любой символ] любое количество

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }*/

      //  ищем только int и float сокращенный вариант
/*        String s = "int = 4, float= 4.0f, double  = 8.0";

        String pattern = "(int|float)\\s*=\\s*\\d[.\\w]*";

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
        }*/

// раздельный вывод см скобки!!! внимательно
/*        String s = "int = 4, float= 4.0f, double  = 8.0";

        String pattern = "(int|float)\\s*=\\s*(\\d[.\\w]*)";

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }*/


// ур 19 1-52 мин ищем ip адрес

/*//       String s = "127.0.0.1";
        String s = "192.168.255.255";

//        String pattern = "\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}";
       String pattern = "(\\d{1,3}\\.){3,}\\d{1,3}";

        Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE); // игнорируем регистр
        Matcher matcher = regex.matcher(s);

        while (matcher.find()) {

            System.out.println(matcher.group());
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
        }*/

// ур 19 2-05 см Practicle


        // ур 19 2-22

/*        String s = "Я ищу совпадения в 2024 году. И я их найду в 2 счёта. 5910. Hel_lo. Ели[-ели].";
        s.split("\\."); // s.split разбивает строку на массив по символу разделителю в данном случае по точке
        String[]arr = s.split("\\."); // сохраняем s.split в массив arr
        System.out.println(Arrays.toString(arr)); // вывод значений массива
        for (String temp:arr){ // создаем переменную yemp пробегаем по массиву arr
            System.out.println(temp); // выводим с новой строки ээлементов. словами потому что разделяет по точке
        }*/

/*        String s = "Суворова Виктория, Россия, Сочи,    +7 999 555 77 33";

        String[]arr = s.split(",\\s*"); //  s.split разбивает строку на массив по символу разделителю и сохраняем s.split в массив arr
        System.out.println(Arrays.toString(arr)); // вывод значений массива
        for (String temp:arr){ // создаем переменную yemp пробегаем по массиву arr
            System.out.println(temp); // выводим с новой строки ээлементов. словами потому что разделяет по точке
        }*/

//
        String s = "05-03-1987 // Дата рождения";
        String s2 = s.replaceAll("\\s//.*", "");
        String s3 = s.replaceAll("\\s//.*", "").replaceAll("-", ".");
        System.out.println("Дата рождения: " + s2);
        System.out.println("Дата рождения: " + s3);









    }
}

/* кол-во повторений -
+ - от 1 до бесконечности
* - от 0 до бесконечности
? - от 0 до 1
 */

