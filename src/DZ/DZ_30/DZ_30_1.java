package DZ.DZ_30;
// через анонимный класс
import java.util.Scanner;

// интерфейс ShortWord
interface ShortWord{
    String shortWord(String word1, String word2);
}
// основной класс main
public class DZ_30_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// анономный класс whatIsShort на основе интерфейса ShortWord. whatIsShort это имя класса
ShortWord whatIsShort = new ShortWord() {
// метод  shortWord
    @Override
    public String shortWord(String word1, String word2) {

        return word1.length() <= word2.length() ? word1 : word2; // реализация метода через тернанрый оператор. сравниваем длину word1 (word1.length) и длину word2 (word2.length) и выводим результат
    }
}; // обязательно ; в аноноимном классе!!!!!
// реализация ввода вользователем строк в классе main
        System.out.print("введите первое слово: ");
        String word1 = scanner.nextLine();
        System.out.print("введите второе слово: ");
        String word2 = scanner.nextLine();

// вывод строк
        System.out.println("Первое слово: " + word1);
        System.out.println("Второе слово: " + word2);
// вызываем метод  shortWord   класса whatIsShort с принимаемыми аргументами word1, word2 и ввыводим результат
        System.out.println("Самое короткое слово: " + whatIsShort.shortWord(word1, word2));// Самое короткое слово: word1/word2


    }
}
