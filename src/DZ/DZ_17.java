package DZ;

import java.util.Scanner;

public class DZ_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        String text = ("Удалите из строки повторяющиеся символы и все пробелы");
        System.out.println("Исходная строка: " + text);
        text = text.replaceAll(" ", ""); // убираем пробелы
        System.out.println("Без пробелов: " + text); //  проверяем пробелы

       String text2 = new String(); //  новая строка в которой будет результат

        for (char c : text.toCharArray()){ // исходную строку в массив, создаем чаровую переменную 'c' и пробегаем по всем символам массива. переменная 'c' на каждой итерации = текущему символу массива

            if (text2.indexOf(c) == -1 ) { // проверяем содержит ли text2 символ 'c'. indexOf ищет первое совпадение с 'c'/ если его нет (значение == -1) то блок if работает и в text2 плюсуется символом 'c'. если совпадение есть то блок if пропускается
         text2 = text2 + c; // в строку результата добавляем символ если выполнено условие if (то есть если символ там еще не содержится)
            }

        }
        System.out.println("Результат: " + text2);

    }
}
