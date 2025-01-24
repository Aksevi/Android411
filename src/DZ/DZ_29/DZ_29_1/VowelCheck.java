package DZ.DZ_29.DZ_29_1;

import java.util.Scanner;

public class VowelCheck {
    public static void main(String[] args)  {
        String text = "";
// ловим исключение
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи строку: ");
        text = scanner.nextLine();
        System.out.println("Исходная строка: " + text);
        checkIn(text); // попытка выполнения метода checkIn
        }catch (NoVowelException e) { // обработка исключения
            System.out.println("В строке \"" + text  + "\" " + e.getMessage());
        }
    }


    public static void checkIn(String message) throws NoVowelException {
// символьный массив с глассными англ и русск языков
        char[] words = {'a', 'e', 'i', 'e', 'o', 'u', 'y', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
// переводим строку в нижний регистр
        message = message.toLowerCase();
// идем по массиву и в переменную "c" кладем все буквы из строки по очереди
        for (char c : message.toCharArray()) {
// перебираем массив vowels и по очереди кладем ее значение в переменную word
            for (char word : words) {
// если "c" совпадает с vowel (то есть находится глассная буква то выводим сообщение из строки 32)
                if (c == word) {
                    System.out.println("В строке " + "\"" + message + "\"" + " глаcные есть");
// прекращаем выполнение кода после первого совпадения
                    return;
                }

            }
        }
// если совпадений в цикле выше не было то выбрасываем исключение
        throw new NoVowelException("глассных нет");

    }
}





