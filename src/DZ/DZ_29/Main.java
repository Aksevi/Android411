package DZ.DZ_29;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//вводим строку
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи строку: ");
        String text = scanner.nextLine();
        System.out.println("Исходная строка: " + text);

// ловим исключение
        try {
            checkVowels(text);
        }
        catch (NoVowelsException e){
//            System.out.println("Глаcных нет в строке " + "\"" + text + "\"");
            System.out.println("В строке \"" + text + "\" " + e.getMessage());

        }

    }

// метод для проверки на наличие глассных
    public static void checkVowels(String str) throws NoVowelsException{
// создаем символьный массив с глассными из русского и англ языков
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'э', 'ю', 'я', 'a', 'e', 'i', 'o', 'u', 'y'};
// строку в нижний регистр переводим
        str = str.toLowerCase();
// идем по массиву и в переменную "c" кладем все буквы из строки по очереди
        for (char c : str.toCharArray()) {
// перебираем массив vowels и по очереди кладем ее значение в переменную vowel
            for (char vowel : vowels) {
// если "c" совпадает с vowel (то есть находится глассная буква то выводим сообщение из строки 38)
                if (c == vowel) {
                    System.out.println("В строке " + "\"" + str + "\"" + " глаcные есть");
// прекращаем выполнение цикла потому что наша задача найти хоть одну глассную букву
                    return;

                }
            }

        }
// если совпадений в цикле выше не было то выбрасываем исключение
throw new NoVowelsException("гласных нет");
    }
}
