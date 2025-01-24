package DZ.DZ_30;
// через лямбда
import java.util.Scanner;
// интерфейс ShortWord3
interface ShortWord3 {
    String shortWord3(String word1, String word2);
}
// основной класс main
public class DZ_30_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// лямбда выражение
        ShortWord3 whatIsShort = (word1, word2) -> word1.length() <= word2.length() ? word1 : word2;
// пользователь выбираеь сколько слов сравнивать
        System.out.print("количество слов:  ");
        int n = scanner.nextInt();
        scanner.nextLine();
// массив строк с глубиной введенной пользователем
        String[] words = new String[n];
// идем по циклу и вводим слова пока i не станет равно шдубине массива
        for (int i = 0; i < n; i++) {

            System.out.print("Ведите слово: ");
            words[i] = scanner.nextLine();
            System.out.print((i + 1)+ " " + "слово " + words[i]);
            System.out.println();

        }
// строковая переменная куда будем помещать слова для сравнения. ей присвоили 0 индекс массива
        String shortWord = words[0];
// идем по массиву
        for (int i = 0; i < n - 1; i++) {
// вызывает метод shortWord3 из интерфейса(лямбда выражения) whatIsShort который сравнивает 2 слова  (shortWord, words[i]) по длинне и возвращает то которое короче. \ .equals(words[i]) проверяет является ли words[i] самым котортким слововм.
            if (whatIsShort.shortWord3(shortWord, words[i]).equals(words[i])) {
// если совпадаето то в shortWord присваивается значение words[i]
                shortWord = words[i];
            }

        }
        System.out.print("самое короткое слово: " + shortWord); // если ввел два слова одинаковой длины выведет первое введенное короткое слово
    }

}

