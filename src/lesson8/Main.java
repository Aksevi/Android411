package lesson8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
//        String text = "\\w+\\s*=\\s*[А-я0-9 .]+";


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

        try {
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
        }





    }
}
/* кол-во повторений -
+ - от 1 до бесконечности
* - от 0 до бесконечности
? - от 0 до 1
 */
