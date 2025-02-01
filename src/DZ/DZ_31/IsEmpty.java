package DZ.DZ_31;
// проверяем пустая ли строка
import java.util.Scanner;
import java.util.function.Predicate;

public class IsEmpty {
    public static void main(String[] args) {
        Predicate<String> isEmpty = str -> str.trim().isEmpty(); // str - строка\ .trim() - убирает пробелы в начале и конце\ .isEmpty() - прверяет пустая ли строка

        String str1 = "Привет";
        String str2 = "    ";
        String str3 = "";

        System.out.println("Строка пустая? -> " + isEmpty.test(str1));
        System.out.println("Строка пустая? -> " + isEmpty.test(str2));
        System.out.println("Строка пустая? -> " + isEmpty.test(str3));

    }
}
