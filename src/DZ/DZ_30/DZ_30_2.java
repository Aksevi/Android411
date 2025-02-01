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

/*// лямбда выражение/ Если его оставить тут то word1 и word2 можно писать
        ShortWord2 whatIsShort = (word1, word2) -> word1.length() <= word2.length() ? word1 : word2;*/

// реализация ввода пользователем строк в классе main
        System.out.print("1 слово  -> ");
        String word1 = scanner.nextLine();
        System.out.print("2 слово -> ");
        String word2 = scanner.nextLine();

// лямбда выражение/ если выражение писать тут (после того как их объявил в 17-20 стр) то word1 и word2 писать нельзя - не могут совпадать имена. поэтому их меняем на любое другое/ дальше их можно и не трогать используя word1  и word2ё
        ShortWord2 whatIsShort = (w1, w2) -> word1.length() <= word2.length() ? word1 : word2;

// вывод слов
        System.out.println("Первое слово: " + word1);
        System.out.println("Второе слово: " + word2);
// вывод результата работы лямбда выражения
        System.out.println("Самое короткое слово: " + whatIsShort.shortetsWord2(word1, word2));



    }
}
