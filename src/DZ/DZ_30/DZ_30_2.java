package DZ.DZ_30;
// через лямбда
import java.util.Scanner;
// интерфейс ShortWord2
interface ShortWord2{
    String shortetsWord2(String word1, String word2);
}
// основной класс main
public class DZ_30_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

/*// лямбда выражение
        ShortWord2 whatIsShort = (word1, word2) -> word1.length() <= word2.length() ? word1 : word2;*/

// реализация ввода пользователем строк в классе main
        System.out.print("1 слово  -> ");
        String word1 = scanner.nextLine();
        System.out.print("2 слово -> ");
        String word2 = scanner.nextLine();

// лямбда выражение
        ShortWord2 whatIsShort = (a, b) -> word1.length() <= word2.length() ? word1 : word2;

// вывод слов
        System.out.println("Первое слово: " + word1);
        System.out.println("Второе слово: " + word2);
// вывод результата работы лямбда выражения
        System.out.println("Самое короткое слово: " + whatIsShort.shortetsWord2(word1, word2));



    }
}
