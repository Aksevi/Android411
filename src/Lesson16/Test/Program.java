package Lesson16.Test;
// 30 31 мин

interface WordCounter{
// метод без реализации - возвращает число поэтому int а принимает строку поэтому String (считает кол-во слов в предложении)
    int countWords(String text);
}


public class Program {
    public static void main(String[] args) {

        String txt  = "  Лямбда выражение";
        System.out.println("Исходная строка: " + txt);

// лямбда выражение 30 38 min
        WordCounter wordCounter = (s) -> s.trim().split("\\s+").length; // разбиваем строку на массив по пробелам trim лишние пробелы слева и справа, split разбивает строку. \\s+ - один или больше пробелов
// созд переменую сount, обращаемся к wordCounter (стр 17) и вызываем метод countWords и передаем в нее строковую переменную txt
        int count = wordCounter.countWords(txt);
        System.out.println(count); // вывод результата (2)

// переопределяем переменную. поэтому без String
        txt = "Программа, которая подсчитывает количество слов в предложении";
        System.out.println("Исходная строка: " + txt);

// переопределяем вызов метода.  поэтому без int
        count = wordCounter.countWords(txt);
        System.out.println(count);

    }
}
