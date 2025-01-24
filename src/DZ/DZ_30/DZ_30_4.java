package DZ.DZ_30;
// через лямбда в несколько строк

import java.util.Scanner;

// интерфейс EqualsWord
interface EqualsWord {

//    void equalsWord(String word1, String word2);// тут надо void так как метод ничего не возвращает. с этой строкой расскоментируй 21, 24, 42
    String equalsWord(String word1, String word2);
}

// основной класс
public class DZ_30_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// лямбда выражение интерфейса EqualsWord сравнивает слова и выводит результат. в интерфейсЕ void потому как сейчас само лямбда выражение выводит результат
//       EqualsWord shortWord = (word1, word2) -> {
        EqualsWord shortWord = (word1, word2) -> {
            if (word1.length() <= word2.length()) {
//               System.out.println("Самое короткое слово: " + word1); // с этой строкой расскоментируй 9, 24, 42
                return word1;
            } else {
//               System.out.println("Самое короткое слово: " + word2);
                return word2;
            }
        };

// метод main ввод пользователдем слов
        System.out.println("Введите первое слово: ");
        String word1 = scanner.nextLine();
        System.out.println("Введите второе слово: ");
        String word2 = scanner.nextLine();
// создаем переменную и в нее сохраняем результат лямбда выражения
        String text;
        text = shortWord.equalsWord(word1, word2);

// вывод слов
        System.out.println("Первое слово: " + word1);
        System.out.println("Второе слово: " + word2);
// вызов метода интерфейса для вывода результата
//           shortWord.equalsWord(word1, word2); // с этой строкой расскоментируй 9, 21, 24
//        System.out.println("самое короткое слово: " + shortWord.equalsWord(word1,word2));
// вывод результата через переменную text
        System.out.println("самое короткое слово: " + text);

    }
}





