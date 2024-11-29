package Lesson7;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

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
    //        String name2 = name.toLowerCase(); //  пересохраняем значение name в name 2 преобразуем в нижний регистр
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

/*            String s = "я буду хорошим программистом";
            System.out.println(s);
            int[] result = new int['я' - 'а' + 1]; // создаем массив из символов на заданную длинну. +1 чтобы не было ошибки и включался последний элемент 33 буквы. я (33) - а(1)  -> 32 (а букв то 33 поэтому +1)
            System.out.println(Arrays.toString(result));
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= 'а' && ch <= 'я') { // проверяет по кодам символов юникода сh больше или равно коду символа 'a' и тд
                    result[ch - 'а']++;

                }
            }
            System.out.println(Arrays.toString(result));
            for (int i = 0; i < result.length; i++) {
                System.out.println((char) (i + 'а') + " = " + result[i]);
            }*/

    //        16 урок начало

    /*        String s1 = "";
    //        if (s1.length() == 0 || s1.isEmpty()) { // s1.length() == 0 || s1.isEmpty()
            if (s1.isEmpty()) { // аналогично предыдущей строке
                System.out.println("Пустая строка");
            }*/

    //        16 урок 5 мин

    /*        String str1 = "Строка";
            char[] res = str1.toCharArray(); // // преобразовали строку в массив где каждый символ попадает в отдельный элемент массива

            System.out.println("Массив символов: ");
            for (int i = 0; i < res.length; i++) { // прошлись циклом по всей длине массива
                System.out.println("Элемент [" + i + "]: " + res[i]); // вывели по принципу "Элемент [n]: a" где n это индекс буквы в массиве, a - буква
            }*/

        // 16 урок 10 мин преобразуем строку в массив символов, проходимся по каждому символу, ищем и заменяем элементы, обратно массив преобразуем в строку и выводим результат

    /*        String path = "https://tanki.su/ru/daily-check-in/?utm_campaign=mt-portal&utm_medium=link&utm_source=home-page";
                    char[] chars = path.toCharArray(); // преобразовали строку в массив, где каждый символ попадает в отдельный элемент массива
            for (int i = 0; i < chars.length; i++) { // проходимся циклом по массиву и ->
                if(chars[i] == '/'){ // если элемент массива равен /, то ->
                    chars[i] = '\\'; // заменяем его на \
                }
            }
            String res = new String (chars); // преобразуем массив обратно в строку: создаем новую переменную и передаем в нее массив типа данных чар
            System.out.println(res);*/

            //        16 урок 15 мин поиск подстроки или символа в строке

    /*        String str1 = "I learning Java";

            System.out.println(str1);
            System.out.println(str1.indexOf('a')); // ищем индекс символа(например буквы a) indexOf находит первое совпадение (вхождение) и останавливает поиск/ если искать то чего нет то выдаст -1
            System.out.println(str1.lastIndexOf('a')); // lastIndexOf ищет последнее вхождение символа
            System.out.println(str1.indexOf('a', 5)); // такой синтаксис позволяет искать с указанного индекса (в данном случае 5) и будет искать а пока не найдет первое совпадение начиная с индекса 5
            System.out.println(str1.lastIndexOf('a', 5)); // такой синтаксис позволяет искать вхождение символа а с 5 индекса к началу строки( то есть ищет с конца считая 5 индекс концом)*/

            //        16 урок 21 мин поиск и удаление пробельных символов

    /*        System.out.println("     Hello World ".trim()); // .trim удаляет пробельные символы в начале и в конце строки*/

            //        16 урок 23 мин получаем подстроку от строки
/*
//        System.out.println("I learning Java".substring(2, 10)); // создаем строку с заданного индекса по заданный индекс. в данном примере 2 индекс включается 10 - нет
//        System.out.println("I learning Java".substring(2)); // с индекса 2 и до конца
// то же самое что и стр 140-141 но подробнее
            String str = "I learning Java"; // создаем строку
        System.out.println(str);
            String str1 = str.substring(2, 10); // применяем к str метод .substring. в str1 сохранилось только то что попало в интервал индексов
        System.out.println(str1);*/

        // УРОК 16 28 мин юзер вводит два слова через пробел программа меняет их местами и выводит результат

/*        System.out.print("Введите два слова через пробел: ");
        String str =input.nextLine(); // юзер вводит два слова через пробел
//        String first = str.substring(0, str.indexOf(" "));//создаем переменную где будет лежать первое слово - его определяем по принципу - от индекса 0 (начало слова) до пробела (слова то через пробел). пробел ищем с помощью метода .indexOf и указываем чтобы он искал первый пробел - .indexOf(" ") причем индекс пробела не включается!
//        System.out.println(first); // проверяем
//       // String second = str.substring(str.indexOf(" ")).trim(); // ищем второе слово - соответственно от пробела и до конца. последний индекс можно не указывать - и так все отработает. но есть ньюанс - если оставить просто str.substring(str.indexOf(" ")) то в выводе перед вторым словом будет лишний пробел. поэтому - используем .trim
//        String second = str.substring(str.indexOf(" ") + 1); // то же самое что и с .trim - просто указываем что нужно к пробельному символу прибавить 1 и начинать с этой позиции
//        System.out.println(second); // проверяем
//        System.out.println(second + " " + first); // выводим
        System.out.println(str.substring(str.indexOf(" ") + 1) + " " + str.substring(0, str.indexOf(" "))); //  выводим. итог такой же как и предыдущая строка. просто взяли и вставили в вывод не переменные а их значение которое прописали выше*/

        // урок 16 39 минут. разделить строку на несколько подстрок

/*        String str1 = "I learning Java";
        String[] words = str1.split("a"); // строку в массив и разбиваем с помощью .split на символы по символу разделителю (в нашем случае это пробел) короче программа считает что все что без пробела это один символ - слово до пробела это один символ. два слова через пробел - два символа. можно указать любой символ и тогда разобьет по этому символу - введи например англ a и выведи результат - будет интересно ;)
        for (String word : words) // создаем переменную word и проходимся по массиву строк words
            System.out.println(word); // выводим переменную word. короче - преобразовали строку в массив строк разбив одну строку на подстроки*/

          // ур 16 43 мин (практика по предыдущей закладке)

/*        System.out.print("Введи ФИО: ");
        String str = input.nextLine(); // юзер вводит -> Акулов Сергей Викторович
        String[] fio = str.split(" ");// преобразуем в массив и разбиваем по пробелу
        System.out.println(Arrays.toString(fio)); // смотрим что получилось -> [Акулов, Сергей, Викторович]
        System.out.println(fio[0] + " " + fio[1].substring(0, 1) + "." + fio[2].substring(0, 1) + "."); // здесь короче  делаем вот что - выводим сперва первую подстроку (массив с индексом 0) + пробел + вторую подстроку (массив с индексом 1), ограниченный 1 символом + точку + третью подстроку (массив с индексом 2), ограниченный 1 символом + точку -> Акулов С.В.

        System.out.println(fio[0] + " " + fio[1].charAt(0) + "." + fio[2].charAt(0) + "."); // можно использовать charAt вместо substring -> Акулов С.В. fio[1].charAt(0) - указываем индекс основного списка и индекс элемента строки. грубо говоря Сергей - это первый список, а буква каждая это строки в нем соответственно Сергей это список [1] а буква С в нем - строка 0*/

        // урок 16 49 минута разворачиваем слово

        // вариант 1
/*        String str = "Строка";
        System.out.println(str);
        char[] res = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(str.length() - 1 -i); //

        }
        System.out.print(res);*/

        // вариант 2

/*        String line = "Строка";
        System.out.println(line);
        String result = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            result += line.charAt(i);
        }
        System.out.println(result);*/

        // вариант 3

/*        String line = "строка"; // начальное слово
        System.out.println(line);
        String result = ""; // результат. изначально он пустой
        for (int i = 0; i < line.length(); i++) { // идем циклом по слову

            result = line.charAt(i) + result; // присваиваем результату буквы пока они не кончаться в слове (в цикле): итерация 0 (i = 0) line.charAt(0) = 'С' result = 'С';  итерация 1 (i = 1) line.charAt(1) = 'т' result = 'тС'; итерация 2 (i = 2) line.charAt(2) = 'р' result = 'ртС' и так далее - > так получается потому что формула такая "result = line.charAt(i) + result;" поменяй местами ("result = result +line.charAt(i);") и строка не перевернется
        }
        System.out.println(result);*/

        // ур 16 1 час объединение нескольких подстрок в одну строку

/*        String res = String.join(":", "00", "23", "30"); // метод join объединил элементы в одну строку через символ разделитель (delimeter)
        System.out.println(res); // 00:23:30

        String[] text = new String[] {"Я", "буду", "хорошим", "программистом"};
        String str = String.join(" ", text);// объединяем подстроки из массива в одну строку через разделитель - пробел
        System.out.println(str); // Я буду хорошим программистом*/

        // ур 16 1 -05 поиск и замена в строке элементов

/*        String text = "Я изучаю JAVA. Мне нравится JAVA.";
        System.out.println(text);
        String[] array = text.split("JAVA");// убираем слово JAVA
        System.out.println(Arrays.toString(array));// [Я изучаю , . Мне нравится , .]
        String res = String.join("Android", array);//делаем символом объединителем слово Android
        System.out.println(res); // Я изучаю Android. Мне нравится Android.*/

        // ур 16 1 -12 поиск и замена в строке элементов 2 вариант

 /*       String text = "Я изучаю JAVA. Мне нравится JAVA.";
        text = text.replace("JAVA","Android"); //replace - замена слова JAVA на Android
        System.out.println(text);*/

        // ур 16 1-14 замена букв о на О кроме первой и последней

// первый вариант
/*        String text = "Замените в этой строке все появления буквы 'о' на букву 'О', кроме первого и последнего вхождения."; // исходная строка
        String text2 = ""; // конечная строка
        char x; // переменная типа чар
        int pos1 = text.indexOf('о'); // ищем индекс первого вхождения буквы "о"
        int pos2 = text.lastIndexOf('о'); // ищем индекс последнего вхождения буквы "о"
        for (int i = 0; i < text.length(); i++) {// проходимся циклом по длине строки
            x = text.charAt(i); // в x ложим символ из строки - он меняется с каждой итерацией
            if (x == 'о' && i != pos1 && i != pos2){
                x = 'О';
            }
            text2 += x; // собираем все данные в общую строку

        }
        System.out.println("Исходная строка: " + text);
        System.out.println("Результат: " + text2);*/


        // второй вариант ур 16 1-42
/*        String tekst = "Замените в этой строке все появления буквы 'о' на букву 'О', кроме первого и последнего вхождения."; // исходная строка
        String a = tekst.substring(0, tekst.indexOf("о") + 1); // создаем переменную и с помощью  substring ищем от начала до первой буквы "о" будет в итоге "Замените в эт" но надо чтобы первая "о" включалась и оставалась маленькой поэтому +1. теперь в переменной а лежит "Замените в это"
        System.out.println(a); //"Замените в это"
        String b = tekst.substring(tekst.indexOf("о") + 1, tekst.lastIndexOf("о"));// ищем от последней буквы "о" с конца до первого совпадения.  чтобы не затронуть первую букву "о" -> tekst.indexOf("о") + 1, и второй аргумент -> tekst.lastIndexOf("о") - последнее вхождение буквы о -> "й строке все появления буквы 'о' на букву 'О', кроме первого и последнего вх"
        System.out.println(b);// "й строке все появления буквы 'о' на букву 'О', кроме первого и последнего вх"
        String c = tekst.substring(tekst.lastIndexOf("о")); // .substring -> разбиваем от последней найденной буквы о до конца. поэтому указан только один параметр
        System.out.println(c); // "ождения."
        // собираем элементы вместе
        System.out.println(a + b.replace("о", "О") + c);*/

        // 16 урок 1-48 сравнение строк

/*       int a = 5; // если цифровые значения то просто сравнение
        int b = 5;
        if (a == b);
        System.out.println("значения переменных равны");*/
/*        String a = "Hello"; // если значения строковые то просто сравнение не всегда корректно. например если в переменную b добавить пробел то все равно программа скажет что а и b  равны
        String b = "Hello";
        String c = "Good-bye";
        String d = "HELLO";
//        if (a == b);
//        System.out.println("значения переменных равны");
        System.out.println(a + " == " + b + " -> " + a.equals(b)); // метод .equals() - метод непосредственного сравнения строк в зависимости от регистра
        System.out.println(a + " == " + c + " -> " + a.equals(c)); // метод .equals() - метод непосредственного сравнения строк в зависимости от регистра
        System.out.println(a + " == " + d + " -> " + a.equals(d)); // метод .equals() - метод непосредственного сравнения строк в зависимости от регистра
        System.out.println(a + " == " + d + " -> " + a.equalsIgnoreCase(d)); // метод .equalsIgnoreCase() - метод непосредственного сравнения строк не зависимо от регистра*/

        // урок 1-57 сравнение части строк и подстрок

/*        System.out.println("I learning Java".endsWith("Java")); //проверяет на какое слово или символ заканчивается строка. результат true/false
        System.out.println("I learning Java".startsWith("I")); //проверяет на какое слово или символ начинается строка. результат true/false
        System.out.println("I learning Java".contains("ing")); //проверяет содержит ли строка слово часть слова или символ  (в данном случае на ing)/ важно - учитывает пробелы. то есть если запросить есть ли в строке learning часть "le arn" то выдаст false (результат true или false)*/

        // пример использования методов сравнения строк ур 16 2-01

/*        System.out.println("Введите название документа: ");
        String path = input.nextLine();

        if (path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png"))
            System.out.println("Это картинка");
        else if (path.endsWith(".html"))
            System.out.println("Это HTML-страница");
        else if (path.endsWith(".doc") || path.endsWith(".docs"))
            System.out.println("Это документ Word");
        else
            System.out.println("Неизвестный формат");*/

        // ур 16 2-08 получаем код символа из таблицы ASCII по индексу

/*       String s = "I learning Java";
//        String s = "Привет мир";

        int n;
        n = s.codePointAt(0);
        System.out.println(n);
        n = s.codePointAt(4);
        System.out.println(n);
        n = s.codePointBefore(3);// codePointBefore() показывает код символа который стоит перед символом под 3м индексом
        System.out.println(n);*/

        // ур 16 2-23 методы перевода разных типов числовых значений в строковые представления

/*        String s ;
//        double d = 3.8596;
//        int d = -385;
//        char d = '+';
        boolean d = true;
        s = String.valueOf(d); // перевод цифрового значения  d  в строковое
        System.out.println(s);*/

        // ур 16 2-27 сравнение строк

        //.compareTo("x") - сравнивает первый и второй элементы - больше меньше первый второго или они равны. если условие дает false то получим в результате отрицательное число. если условие дает true - то в результате получаем положительное число. если равны то получим 0. резултат это разница между кодом символа в таблице юникода. отрицательное значение говорит о том что первый элемент НЕ БОЛЬШЕ второго

/*        String str = "1";
        System.out.println("1 > 5: " + str.compareTo("5")); // отрицательное число
        System.out.println("1 == 5: " + str.compareTo("1")); // ноль
        str = "7";
        System.out.println("7 == 5: " + str.compareTo("1")); // положительное число*/

        // работает и с цифрами и буквами - ему пофиг это все символы имеющие код
/*        String str = "a";
        System.out.println("1 > d: " + str.compareTo("d")); // отрицательное число
        System.out.println("a == a: " + str.compareTo("a")); // ноль
        str = "t";
        System.out.println("t == d: " + str.compareTo("t"));*/

// ур 16 2-37
/*        String str = "Привет";
        System.out.println("Привет > привет: " + str.compareTo("привет")); // работает так - у П код - 1055 у п - 1087 -> 1055 > 1087 = -32 остальные все сходятся
        String str1 = "пРивет";
        System.out.println("пРивет > привет: " + str1.compareTo("привет")); // сравнивает до первого различия. между Р и р так же разница 32. так как крд Р не больше кода р то отрицательное значение. если сделать пРИвет > привет то все равно будет -32 так как сравнивает до первого различия и результат не суммируется
        System.out.println("пРивет > привет: " + str1.compareToIgnoreCase("привет"));*/


        // ур 16 2-42 юзер вводит текст выбирает что на что меняем и выводим резултат

        // мой вариант
/*        System.out.println("Введите текст: ");
        String s = scanner.nextLine();

        System.out.println("Введите что меняем: ");
        String a = scanner.nextLine();

        System.out.println("Введите на что меняем: ");
        String b = scanner.nextLine();

        System.out.println(s);

        if (s.contains(a)) { // это условие нужно чтобы при вводе того значения которого нет корректно работало

            String res = s.replace(a, b); //replace - замена a на b
            System.out.println(res);
        }else {
            System.out.println("нет элемента для замены");
        }*/











    }

}
