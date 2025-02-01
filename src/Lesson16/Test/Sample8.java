package Lesson16.Test;
// 31 4 мин

interface Converter<F, T>{ // F T дженерики. их два типа в интерфейсе
   T convert(F from); // принимает один тип данных а возвращает другой. в 9 и 10 строках T = String, F = Integer
}
public class Sample8 {
    public static void main(String[] args) {
//        Converter<String, Integer> converter = (String from) -> Integer.valueOf(from);// это parseInt(String s) лямбда выражение перевода текста в числа
        Converter<String, Integer> converter = Integer::valueOf;// то же самое что предыдущая строка
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }
}
